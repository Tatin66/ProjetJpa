package com.example.popjpa

import com.example.popjpa.entity.CommandeEntity
import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.service.CommandeService
import com.example.popjpa.service.ProduitService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class OrderForm(
    var products: List<ProduitEntity>? = null,
    val name: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val date: String? = null
)

@Controller
class CommandeController(val produitService: ProduitService, val commandeService: CommandeService) {

    @GetMapping("/commande")
    fun commandes(model: Model, orderForm: OrderForm): String {
        orderForm.products = produitService.getAllProduits()
        return "commande"
    }

    @PostMapping("/formSubmit")
    fun formSubmit(@ModelAttribute orderForm: OrderForm, request: HttpServletRequest): String {
        val products = orderForm.products
        val name = orderForm.name
        val phoneNumber = orderForm.phoneNumber
        val email = orderForm.email
        val date = orderForm.date
        val sessionId = request.session.id
        var productsBuy = ArrayList<ProduitEntity>()

        // Traiter les données du formulaire
        if (products != null) {
            for(product in products){
                if(product.quantity!! > 0){
                    productsBuy.add(product)
                    println(productsBuy)
                }
            }
            var newCommande = CommandeEntity(session_id = sessionId, telephone = phoneNumber, nom = name, date = date, produit = productsBuy)
            commandeService.saveCommande(newCommande)
        }

        return "redirect:/commande"
    }
}
