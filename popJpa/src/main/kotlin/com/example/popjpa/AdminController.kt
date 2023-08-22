package com.example.popjpa

import com.example.popjpa.entity.AdminDao
import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.service.ProduitService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class AdminController (private val produitService: ProduitService) {

    @GetMapping("/adminConnexion")
    fun showFormAdminConnexion(model: Model): String {
        model.addAttribute("admin", AdminDao())
        return "adminConnexion"
    }

    @PostMapping("/loginSubmit")
    fun loginSubmitAndRedirection(@ModelAttribute admin: AdminDao): String {
        // Instance Admin avec les bonnes valeurs
        val adminCredentials = AdminDao(login = "root", password = "root")

        if (admin.login == adminCredentials.login && admin.password == adminCredentials.password) {
            // Les identifiants sont valides, redirigez vers une nouvelle page
            return "redirect:/adminPage"
        } else {
            // Redirigez vers la page de connexion
            return "redirect:/adminConnexion"
        }
    }

    // Connexion réussie : redirection vers la page administration
    @GetMapping("/adminPage")
    fun showAdminDashboard(model: Model): String {
        // Obtenir la liste de tous les produits
        val produits = produitService.getAllProduits()
        // println(produits)
        // Ajoutez la liste au modèle / afficher sur la page
        model.addAttribute("products", produits)
        return "adminPage"
    }

    @GetMapping("/adminPage/activate/{id}")
    fun activateProduit(@PathVariable id: Long): String {
        // Appel au service pour activer le produit / en fonction id
        produitService.activateProduit(id)
        // Redirection vers la page d'administration / mise à jour affichage
        return "redirect:/adminPage"
    }

    @GetMapping("/adminPage/deactivate/{id}")
    fun deactivateProduit(@PathVariable id: Long): String {
        // Appel au service pour désactiver le produit
        produitService.deactivateProduit(id)
        // Redirection vers la page d'administration
        return "redirect:/adminPage"
    }

    @PostMapping("/adminPage/addProduct")
    fun addProduct(
        @RequestParam productName: String,
        @RequestParam productImage: String,
        @RequestParam productQuantity: Int,
        @RequestParam productPrice: Float,
        @RequestParam productActive: Boolean
    ): String {
        // Creér un nouvel objet produit / passer les variable (requestParam)
        val newProduct = ProduitEntity(
            name = productName,
            url_image = productImage,
            quantity = productQuantity,
            prix = productPrice,
            active = productActive
        )
        // Appel au service pour sauvegarder le nouveau produit
        produitService.saveProduit(newProduct)
        // Redirection vers la page d'administration / Mise à jour affichage
        return "redirect:/adminPage"
    }

    @GetMapping("/adminPage/delete/{id}")
    fun deleteProduit(@PathVariable id: Long): String {
        // Appel au service pour supprimer le produit
        produitService.deleteProduit(id)
        // Redirection vers la page d'administration / Mise à jour affichage
        return "redirect:/adminPage"
    }
}
