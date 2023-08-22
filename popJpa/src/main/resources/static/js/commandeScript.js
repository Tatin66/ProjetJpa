document.addEventListener("DOMContentLoaded", function() {
    const productCards = document.querySelectorAll(".product-card");

    productCards.forEach(card => {
        const clickCounter = card.querySelector(".click-counter");
        const incrementButton = card.querySelector(".increment-button");
        const removeButton = card.querySelector(".remove-button");
        const hiddenInput = card.querySelector("input[type=hidden]");

        let count = parseInt(hiddenInput.value); // Initialiser le compteur à partir de la valeur cachée

        clickCounter.textContent = count;

        updateRemoveButtonVisibility();

        incrementButton.addEventListener("click", function() {
            count++;
            clickCounter.textContent = count;
            hiddenInput.value = count; // Mettre à jour la valeur cachée
            updateRemoveButtonVisibility();
        });

        removeButton.addEventListener("click", function() {
            if (count > 0) {
                count--;
                clickCounter.textContent = count;
                hiddenInput.value = count; // Mettre à jour la valeur cachée
                updateRemoveButtonVisibility();
            }
        });

        function updateRemoveButtonVisibility() {
            if (count > 0) {
                removeButton.style.display = "block";
            } else {
                removeButton.style.display = "none";
            }
        }
    });
});