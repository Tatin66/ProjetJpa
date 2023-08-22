package com.example.popjpa

import com.example.popjpa.service.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping


class OrderForm {
    private val name: String? = null
    private val phoneNumber: String? = null
    private val email: String? = null // Autres champs et getters/setters
}

@Controller
class CommandeController(val produitService: ProduitService) {

    @GetMapping("/commande")
    fun commandes(model: Model): String{
        val produitListe = produitService.getAllProduits()

        println(produitListe)
        model.addAttribute("productList", produitListe)
        return "commande"
    }

}
