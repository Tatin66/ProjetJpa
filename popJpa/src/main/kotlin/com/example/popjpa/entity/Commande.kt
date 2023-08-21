package com.example.popjpa.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "commande")
data class CommandeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_commande: Long? = null,
    var session_id : String? = null,
    var telephone : String? = null,
    var nom: String? = null,
    var date: Date? = null,

    @ManyToMany
    @JoinTable(
    name = "commande_produit", //Nom de la table intermédiaire
    //Clé étrangère représentant cette classe
    joinColumns = [JoinColumn(name = "fk_commande_produit")],
    //Clé étrangère représentant l'autre classe
    inverseJoinColumns = [JoinColumn(name = "fk_produit_commande")]
    )

    var produit: List<ProduitEntity>? = ArrayList()
)
