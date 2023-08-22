package com.example.popjpa

import com.example.popjpa.entity.AdminDao
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AdminController {

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
    fun showAdminDashboard(): String {
        // Chargez les données nécessaires pour le tableau de bord de l'administrateur
        return "adminPage" // Remplacez par le nom de votre vue pour le tableau de bord
    }
}
