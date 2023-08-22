package com.example.popjpa

import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.service.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

data class OrderForm(
    var products: List<ProduitEntity>? = null,
    val name: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null
)

@Controller
class CommandeController(val produitService: ProduitService) {

    @GetMapping("/commande")
    fun commandes(model: Model, orderForm: OrderForm): String {
        orderForm.products = produitService.getAllProduits()

        return "commande"
    }

    @PostMapping("/formSubmit")
    fun formSubmit(orderForm: OrderForm): String {
        val products = orderForm.products
        val name = orderForm.name
        val phoneNumber = orderForm.phoneNumber
        val email = orderForm.email

        // Traitez les données du formulaire
        if (products != null) {
            for (product in products) {
                val productId = product.id_produit
                val quantity = product.quantity

                println("Product ID: $productId, Quantity: $quantity")
            }
        }

        return "redirect:/commande"
    }
}
