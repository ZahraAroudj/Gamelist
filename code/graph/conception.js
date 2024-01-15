// script.js
let slideIndex = 0;
const slides = document.querySelectorAll('.slide');

function showSlide(index) {
    if (index < 0) {
        slideIndex = slides.length - 1;
    } else if (index >= slides.length) {
        slideIndex = 0;
    }

    slides.forEach(slide => {
        slide.style.display = 'none';
    });

    slides[slideIndex].style.display = 'block';
}

function prevSlide() {
    slideIndex--;
    showSlide(slideIndex);
}

function nextSlide() {
    slideIndex++;
    showSlide(slideIndex);
}

// Affiche la première image au chargement de la page
showSlide(slideIndex);

//pour le zoom
const zoomImage = document.getElementById('zoomImage');

zoomImage.addEventListener('mousemove', (e) => {
    const rect = zoomImage.getBoundingClientRect();
    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;
    const centerX = rect.width / 2;
    const centerY = rect.height / 2;

    const deltaX = (x - centerX) / centerX;
    const deltaY = (y - centerY) / centerY;

    const scale = 2; // Facteur de zoom

    zoomImage.style.transform = `scale(${scale}) translate(${-deltaX * 50}px, ${-deltaY * 50}px)`;
});

zoomImage.addEventListener('mouseleave', () => {
    zoomImage.style.transform = 'scale(1)';
});