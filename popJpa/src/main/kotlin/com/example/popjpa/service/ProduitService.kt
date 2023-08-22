package com.example.popjpa.service

import com.example.popjpa.entity.ProduitEntity
import com.example.popjpa.repository.ProduitRepository
import org.springframework.stereotype.Service

@Service
class ProduitService(val produitRepository: ProduitRepository) {
    fun getProduit(): MutableList<ProduitEntity> {
        return produitRepository.findAll()
    }
}
