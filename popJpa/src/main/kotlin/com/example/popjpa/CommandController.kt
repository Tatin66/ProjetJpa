package com.example.popjpa

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@Controller
class CommandController {

    @GetMapping("/commandes")
    fun commandes(): String{
        println("commandes")
        return "/commandes"
    }
}