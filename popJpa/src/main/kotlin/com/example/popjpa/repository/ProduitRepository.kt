package com.example.popjpa.repository

import com.example.popjpa.entity.CommandeEntity
import com.example.popjpa.entity.ProduitEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository                       //<Bean, Typage Id>
interface ProduitRepository : JpaRepository<ProduitEntity, Long> {

}
