// Function to toggle hamburger menu
function toggleMenu() {
    const navMenu = document.querySelector('.nav-menu');
    const exitButton = document.querySelector('.exit-button');

    navMenu.classList.toggle('show');
    exitButton.style.display = navMenu.classList.contains('show') ? 'block' : 'none';
}

// Function to zoom in on image
function zoomImage(src) {
    const modal = document.getElementById('imageModal');
    const modalImg = document.getElementById('modalImage');

    modal.style.display = 'block';
    modalImg.src = src;
}

// Function to close modal
function closeModal() {
    const modal = document.getElementById('imageModal');
    modal.style.display = 'none';
}

document.addEventListener('DOMContentLoaded', function() {
    const menuSections = document.querySelectorAll('.menu-section h3');
    const navMenu = document.querySelector('.nav-menu');

    // Toggle visibility of menu sections
    menuSections.forEach(section => {
        section.addEventListener('click', () => {
            const ul = section.nextElementSibling;
            ul.classList.toggle('hidden');
        });
    });

    // Event listener for all links inside the nav menu
    navMenu.querySelectorAll('a').forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault(); // Prevent default link behavior
            const targetId = this.getAttribute('href').substring(1); // Get target section id
            const targetSection = document.getElementById(targetId); // Find the target section

            if (targetSection) {
                targetSection.scrollIntoView({
                    behavior: 'smooth'
                });

                // Close menu after clicking a link
                navMenu.classList.remove('show');
            }
        });
    });
});
