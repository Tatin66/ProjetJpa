package com.example.popjpa

import com.example.popjpa.repository.ProduitRepository
import com.example.popjpa.service.CommandeService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CommandeController(val commandeService: CommandeService) {

    @GetMapping("/commande")
    fun commandes(): String{
        println("commande")
        val commande = commandeService.getCommande()
        println(commande)
        return "commande"
    }


}
