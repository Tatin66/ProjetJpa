package com.example.popjpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "produit")
data class ProduitEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_produit: Long? = null,
    var name: String? = null,
    var url_image: String? = null,
    var quantity: Int? = null,
    var prix: Float? = null,

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
        return "ProduitEntity(id_produit=$id_produit, name=$name, url_image=$url_image, quantity=$quantity, prix=$prix)"
    }
}
