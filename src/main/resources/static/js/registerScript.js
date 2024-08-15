document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('registerForm');

    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const firstName = document.getElementById('firstName').value.trim();
        const lastName = document.getElementById('lastName').value.trim();
        const age = document.getElementById('age').value.trim();
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();

        const nameRegex = /^[A-Za-z\s]+$/;
        const ageRegex = /^\d+$/;
        const usernameRegex = /^[A-Za-z0-9_]+$/;
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;

        if (!nameRegex.test(firstName)) {
            alert('Please enter a valid first name (letters and spaces only).');
            return;
        }

        if (!nameRegex.test(lastName)) {
            alert('Please enter a valid last name (letters and spaces only).');
            return;
        }

        if (!ageRegex.test(age) || age <= 0) {
            alert('Please enter a valid age (positive numbers only).');
            return;
        }

        if (!usernameRegex.test(username)) {
            alert('Please enter a valid username (letters, numbers, and underscores only).');
            return;
        }

        if (!passwordRegex.test(password)) {
            alert('Password must be at least 8 characters long and contain both letters and numbers.');
            return;
        }

        // If all validations pass, submit the form
        registerForm.submit();
    });
});
