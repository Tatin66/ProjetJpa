package com.example.popjpa.service

import com.example.popjpa.entity.CommandeEntity
import com.example.popjpa.repository.CommandeRepository
import org.springframework.stereotype.Service

@Service
class CommandeService(val commandRepository: CommandeRepository) {
    fun getCommande(): MutableList<CommandeEntity> {
        return commandRepository.findAll()
    }
}