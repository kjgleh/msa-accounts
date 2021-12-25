package me.kjgleh.msa.accounts.controller

import me.kjgleh.msa.accounts.dto.SignupDto
import me.kjgleh.msa.accounts.dto.AccountDto
import me.kjgleh.msa.accounts.serivce.SignupService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController(
    private val signupService: SignupService
) {

    @PostMapping("/signup")
    fun signup(@RequestBody signupDto: SignupDto): ResponseEntity<AccountDto> {
        val user = signupService.signup(signupDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello accounts service"
    }
}