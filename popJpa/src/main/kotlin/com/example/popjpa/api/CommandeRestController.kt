package com.example.popjpa.api

import com.example.popjpa.service.CommandeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CommandeRestController(private val commandeService: CommandeService) {

    // Récupérer liste de commande du jour
    // http://localhost:8000/api/commandes-du-jour?password=root
    @GetMapping("/commandes-du-jour")
    fun getCommandesDuJour(@RequestParam password: String): ResponseEntity<Any> {
        return if (password == "root") {
            val commandesDuJour = commandeService.getCommandesDuJour()
            // return OK : 200 + liste de commande du jour
            ResponseEntity.ok(commandesDuJour)
        } else {
            // return 401 : Unauthorized + message d'erreur
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erreur : Mot de passe incorrect")
        }
    }
}
