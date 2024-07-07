function zoomImage(src) {
    const modal = document.getElementById('imageModal');
    const modalImg = document.getElementById('modalImage');

    modal.style.display = 'block';
    modalImg.src = src;
}

function closeModal() {
    const modal = document.getElementById('imageModal');
    modal.style.display = 'none';
}

function toggleMenu() {
    const navMenu = document.getElementById('nav-menu');
    navMenu.classList.toggle('show');
}

document.addEventListener('DOMContentLoaded', function() {
    const menuSections = document.querySelectorAll('.menu-section h3');
    
    menuSections.forEach(section => {
        section.addEventListener('click', () => {
            const ul = section.nextElementSibling;
            ul.classList.toggle('hidden');
        });
    });
});
