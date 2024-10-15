// Function to toggle hamburger menu
function toggleMenu() {
    const navMenu = document.querySelector('.nav-menu');
    navMenu.classList.toggle('show');
    const exitButton = document.querySelector('.exit-button');
    exitButton.style.display = navMenu.classList.contains('show') ? 'block' : 'none';
}

// Function to zoom in on image
function zoomImage(src) {
    const modal = document.getElementById('imageModal');
    const modalImg = document.getElementById('modalImage');
    const hamburger = document.querySelector('.hamburger');

    modal.style.display = 'block';
    modalImg.src = src;

    // Add modal-active class to hamburger when modal is open
    hamburger.classList.add('modal-active');
}

// Function to close modal
function closeModal() {
    const modal = document.getElementById('imageModal');
    const hamburger = document.querySelector('.hamburger');

    modal.style.display = 'none';

    // Remove modal-active class from hamburger when modal is closed
    hamburger.classList.remove('modal-active');
}

document.addEventListener('DOMContentLoaded', function() {
    const menuSections = document.querySelectorAll('.menu-section h3');
    const navLinks = document.querySelectorAll('.nav-menu a');

    menuSections.forEach(section => {
        section.addEventListener('click', () => {
            const ul = section.nextElementSibling;
            ul.classList.toggle('hidden');
        });
    });

    navLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault(); // Prevent default link behavior
            const targetId = this.getAttribute('href').substring(1); // Get target section id
            const targetSection = document.getElementById(targetId); // Find the target section

            if (targetSection) {
                targetSection.scrollIntoView({
                    behavior: 'smooth'
                });

                // Close the hamburger menu after clicking a link
                const navMenu = document.querySelector('.nav-menu');
                navMenu.classList.remove('show');
                const exitButton = document.querySelector('.exit-button');
                if (exitButton) {
                    exitButton.style.display = 'none';
                }
            }
        });
    });
});