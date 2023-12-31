package com.example.popjpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "commande")
data class CommandeEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_commande: Long? = null,
    var session_id : String? = null,
    var telephone : String? = null,
    var nom: String? = null,
    var date: String? = null,

    @ManyToMany(fetch = FetchType.EAGER)
    // FetchType.EAGER:
    // Lorsqu'une entité est chargée, les associations marquées avec EAGER seront également chargées immédiatement.
    @JoinTable(
    name = "commande_produit", //Nom de la table intermédiaire
    //Clé étrangère représentant cette classe
    joinColumns = [JoinColumn(name = "id_commande")],
    //Clé étrangère représentant l'autre classe
    inverseJoinColumns = [JoinColumn(name = "id_produit")]
    )

    var produit: List<ProduitEntity>? = ArrayList()
)
