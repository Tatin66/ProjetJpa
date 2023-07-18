package com.example.popjpa

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
class MyController {

    @GetMapping("/test")
    fun test(): String{
        println("test")
        return "/index"
    }
}