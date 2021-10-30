package me.kjgleh.msa.accounts.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello accounts service"
    }
}