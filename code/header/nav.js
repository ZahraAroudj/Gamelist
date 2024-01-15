const carousel = document.querySelector('.carousel-wrapper');
const personas = document.querySelectorAll('.persona');
let currentIndex = 0;

function rotateCarousel() {
    const angle = currentIndex * -120; // Angle de rotation
    carousel.style.transform = `translateZ(-300px) rotateY(${angle}deg)`;
}

// Fonction pour avancer dans le carrousel
function nextPersona() {
    currentIndex = (currentIndex + 1) % personas.length;
    rotateCarousel();
}

// Fonction pour reculer dans le carrousel
function prevPersona() {
    currentIndex = (currentIndex - 1 + personas.length) % personas.length;
    rotateCarousel();
}

// Gestionnaires d'événements pour les boutons de contrôle
document.querySelector('.prev-button').addEventListener('click', prevPersona);
document.querySelector('.next-button').addEventListener('click', nextPersona);