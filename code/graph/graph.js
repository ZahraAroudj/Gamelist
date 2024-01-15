// script.js
const fullscreenImage = document.getElementById('fullscreenImage');
const imageContainer = document.querySelectorAll('.image-container');

//permet d'appeler les 3 images
for ( let i = 0; i<imageContainer.length; i++) {


imageContainer[i].addEventListener('click', () => {
    if (document.fullscreenElement) {
        // Si l'image est déjà en plein écran, sortez du mode plein écran
        document.exitFullscreen();
    } else {
        // Sinon, mettez l'image en plein écran
        //permet d'appeler la classe au lieu de l'id
        let img = imageContainer[i].querySelector('.fullscreen-image');
        
       img.style.display = 'block';
       img.requestFullscreen().catch(err => {
            console.error('Erreur lors du passage en plein écran :', err);
        });
    }
});
}
// Écoutez l'événement de sortie du mode plein écran
document.addEventListener('fullscreenchange', () => {
  
    }
);

