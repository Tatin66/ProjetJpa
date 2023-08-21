document.addEventListener("DOMContentLoaded", function() {
    const productCards = document.querySelectorAll(".product-card");

    productCards.forEach(card => {
        const clickCounter = card.querySelector(".click-counter");
        const incrementButton = card.querySelector(".increment-button");
        const removeButton = card.querySelector(".remove-button");

        let count = 0;
        clickCounter.textContent = count;

        updateRemoveButtonVisibility(); // Appel initial pour gérer la visibilité

        incrementButton.addEventListener("click", function() {
            count++;
            clickCounter.textContent = count;
            updateRemoveButtonVisibility(); // Mettre à jour la visibilité du bouton de suppression
        });

        removeButton.addEventListener("click", function() {
            if (count > 0) {
                count--;
                clickCounter.textContent = count;
                updateRemoveButtonVisibility(); // Mettre à jour la visibilité du bouton de suppression
            }
        });

        function updateRemoveButtonVisibility() {
            if (count > 0) {
                removeButton.style.display = "block"; // Afficher le bouton si le nombre est supérieur à 0
            } else {
                removeButton.style.display = "none"; // Masquer le bouton si le nombre est égal à 0
            }
        }
    });
});
