document.addEventListener('DOMContentLoaded', () => {
    const shell = document.querySelector('.auth-shell');
    if (shell) {
        shell.animate(
            [
                { opacity: 0, transform: 'translateY(10px)' },
                { opacity: 1, transform: 'translateY(0)' }
            ],
            { duration: 500, easing: 'ease-out', fill: 'forwards' }
        );
    }

    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');
    const hint = document.getElementById('password-match-message');

    if (!password || !confirmPassword || !hint) {
        return;
    }

    const updateHint = () => {
        if (!confirmPassword.value) {
            hint.textContent = 'Use at least 8 characters.';
            return;
        }

        hint.textContent = password.value === confirmPassword.value
            ? 'Passwords match.'
            : 'Passwords do not match yet.';
    };

    password.addEventListener('input', updateHint);
    confirmPassword.addEventListener('input', updateHint);
    updateHint();
});
