package com.example.popjpa.repository

import com.example.popjpa.entity.CommandeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository                       //<Bean, Typage Id>
interface CommandeRepository : JpaRepository<CommandeEntity, Long> {

}
