package com.javajinn.auth_service.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javajinn.auth_service.domain.Role;
import com.javajinn.auth_service.domain.UserAccount;
import com.javajinn.auth_service.dto.SignupRequest;
import com.javajinn.auth_service.repository.RoleRepository;
import com.javajinn.auth_service.repository.UserAccountRepository;

@Service
public class RegistrationService {

    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(
            UserAccountRepository userAccountRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(SignupRequest request) {
        String normalizedUsername = request.getUsername().trim();
        String normalizedEmail = request.getEmail().trim().toLowerCase();

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }
        if (userAccountRepository.existsByUsernameIgnoreCase(normalizedUsername)) {
            throw new IllegalArgumentException("This username is already taken.");
        }
        if (userAccountRepository.existsByEmailIgnoreCase(normalizedEmail)) {
            throw new IllegalArgumentException("This email is already registered.");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Default role ROLE_USER is missing."));

        UserAccount user = new UserAccount();
        user.setUsername(normalizedUsername);
        user.setEmail(normalizedEmail);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(userRole);

        userAccountRepository.save(user);
    }
}
