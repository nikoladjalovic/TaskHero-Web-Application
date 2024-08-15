document.addEventListener('DOMContentLoaded', () => {
    const taskForm = document.getElementById('taskForm');
    const taskList = document.getElementById('taskList');

    taskForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const taskText = document.getElementById('taskText').value;
        const username = document.querySelector('input[name="username"]').value;

        if (taskText === '') {
            alert('Please enter a task');
            return;
        }

        fetch('/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: `taskText=${taskText}&username=${username}`
        }).then(response => {
            if (response.ok) {
                window.location.reload();
            } else {
                alert('Error saving task');
            }
        });
    });

    taskList.addEventListener('click', function(event) {
        if (event.target.matches('.buttonDelete input[type="submit"]')) {
            event.preventDefault();
            const form = event.target.closest('form');
            fetch('/tasks/delete', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams(new FormData(form))
            }).then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('Error deleting task');
                }
            });
        }

        if (event.target.matches('.buttonUpdate input[type="submit"]')) {
            event.preventDefault();
            const form = event.target.closest('form');
            fetch('/tasks/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams(new FormData(form))
            }).then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('Error updating task');
                }
            });
        }
    });
});