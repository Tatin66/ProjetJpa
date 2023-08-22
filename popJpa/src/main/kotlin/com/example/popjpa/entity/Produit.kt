package com.example.popjpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "produit")
data class ProduitEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id_produit: Long? = null,
    val name: String? = null,
    val url_image: String? = null,
    val quantity: Int? = null,
    val prix: Float? = null,
    var active: Boolean? = true,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "commande_produit", //Nom de la table intermédiaire
    //Clé étrangère représentant cette classe
    joinColumns = [JoinColumn(name = "id_produit")],
    //Clé étrangère représentant l'autre classe
    inverseJoinColumns = [JoinColumn(name = "id_commande")]
    )
    var commande: List<CommandeEntity>? = ArrayList()


) {
    override fun toString(): String {
        return "ProduitEntity(id_produit=$id_produit, name=$name, url_image=$url_image, quantity=$quantity, prix=$prix, active=$active)"
    }
}
