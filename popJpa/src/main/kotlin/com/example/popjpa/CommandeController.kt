package com.example.popjpa

import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.repository.ProduitRepository
import com.example.popjpa.service.CommandeService
import com.example.popjpa.service.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.thymeleaf.util.StringUtils.append

@Controller
class CommandeController(val produitService: ProduitService) {

    @GetMapping("/commande")
    fun commandes(model: Model): String{
        val produitListe = produitService.getProduit()

        println(produitListe)
        model.addAttribute("productList", produitListe)
        return "commande"
    }


}
