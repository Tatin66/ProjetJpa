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
        model.addAttribute("admin", AdminDao()) // Ajoutez une instance d'AdminDao au modèle
        return "adminConnexion"
    }

    @PostMapping("/loginSubmit")
    fun loginSubmitAndRedirection(@ModelAttribute admin: AdminDao): String {
        val adminCredentials = AdminDao(login = "root", password = "root") // Créez une instance de référence avec les valeurs correctes

        if (admin.login == adminCredentials.login && admin.password == adminCredentials.password) {
            // Les identifiants sont valides, redirigez vers une nouvelle page
            return "redirect:/adminPage"
        } else {
            // Redirigez vers la page de connexion avec le paramètre d'erreur
            return "redirect:/adminConnexion"
        }
    }

    // Cette route doit correspondre à la redirection réussie ci-dessus
    @GetMapping("/adminPage")
    fun showAdminDashboard(model: Model): String {
        val produits = produitService.getAllProduits() // Obtenez la liste de tous les produits depuis le service
        println(produits)
        model.addAttribute("products", produits) // Ajoutez la liste au modèle
        return "adminPage"
    }

    @GetMapping("/adminPage/activate/{id}")
    fun activateProduit(@PathVariable id: Long): String {
        produitService.activateProduit(id) // Appel au service pour activer le produit
        return "redirect:/adminPage" // Redirection vers la page d'administration
    }

    @GetMapping("/adminPage/deactivate/{id}")
    fun deactivateProduit(@PathVariable id: Long): String {
        produitService.deactivateProduit(id) // Appel au service pour désactiver le produit
        return "redirect:/adminPage" // Redirection vers la page d'administration
    }

    @PostMapping("/adminPage/addProduct")
    fun addProduct(
        @RequestParam productName: String,
        @RequestParam productImage: String,
        @RequestParam productQuantity: Int,
        @RequestParam productPrice: Float,
        @RequestParam productActive: Boolean
    ): String {
        val newProduct = ProduitEntity(
            name = productName,
            url_image = productImage,
            quantity = productQuantity,
            prix = productPrice,
            active = productActive
        )
        produitService.saveProduit(newProduct) // Appel au service pour sauvegarder le nouveau produit
        return "redirect:/adminPage" // Redirection vers la page d'administration
    }

    @GetMapping("/adminPage/delete/{id}")
    fun deleteProduit(@PathVariable id: Long): String {
        produitService.deleteProduit(id) // Appel au service pour supprimer le produit
        return "redirect:/adminPage" // Redirection vers la page d'administration
    }
}
