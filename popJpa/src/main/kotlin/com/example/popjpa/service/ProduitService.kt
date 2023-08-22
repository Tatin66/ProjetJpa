package com.example.popjpa.service

import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.repository.ProduitRepository
import org.springframework.stereotype.Service

@Service
class ProduitService(private val produitRepository: ProduitRepository) { // Injectez le repository de produit

    fun getAllProduits(): List<ProduitEntity> {
        return produitRepository.findAll()
    }

    fun saveProduit(newProduct: ProduitEntity): ProduitEntity {
        return produitRepository.save(newProduct)
    }

    fun activateProduit(id: Long) {
        val produit = produitRepository.findById(id).orElse(null)
        produit?.let {
            it.active = true
            produitRepository.save(it)
        }
    }

    fun deactivateProduit(id: Long) {
        val produit = produitRepository.findById(id).orElse(null)
        produit?.let {
            it.active = false
            produitRepository.save(it)
        }
    }
}
