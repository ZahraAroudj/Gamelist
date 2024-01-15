document.addEventListener("DOMContentLoaded", function () {
    const menuLinks = document.querySelectorAll(".menu a");
    const images = document.querySelectorAll(".images img");

    menuLinks.forEach((link, index) => {
        link.addEventListener("click", (e) => {
            e.preventDefault();
            images.forEach((img) => {
                img.style.display = "none"; // Masquer toutes les images
            });
            images[index].style.display = "block"; // Afficher l'image correspondante
        });
    });
});


