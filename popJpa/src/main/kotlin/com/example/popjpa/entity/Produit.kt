package com.example.popjpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "produit")
data class ProduitEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idProduit: Long? = null,
    val name: String? = null,
    val urlImage: String? = null,
    val quantity: Int? = null,
    val prix: Float? = null,

    @ManyToMany
    @JoinTable(
    name = "commande_produit", //Nom de la table intermédiaire
    //Clé étrangère représentant cette classe
    joinColumns = [JoinColumn(name = "fk_produit_commande")],
    //Clé étrangère représentant l'autre classe
    inverseJoinColumns = [JoinColumn(name = "fk_commande_produit")]
    )

    var commande: List<CommandeEntity>? = ArrayList()
)
