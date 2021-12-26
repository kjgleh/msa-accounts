package me.kjgleh.msa.accounts.controller

import me.kjgleh.msa.accounts.dto.SignupDto
import me.kjgleh.msa.accounts.dto.AccountDto
import me.kjgleh.msa.accounts.serivce.SignupService
import me.kjgleh.msa.accounts.utils.JwtUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AccountsController(
    private val signupService: SignupService,
    private val jwtUtil: JwtUtil,
) {

    @PostMapping("/signup")
    fun signup(@RequestBody signupDto: SignupDto): ResponseEntity<String> {
        val account = signupService.signup(signupDto)
        val jwt = jwtUtil.issue(UUID.fromString(account.uuid))
        return ResponseEntity.status(HttpStatus.CREATED).body(jwt)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello accounts service"
    }
}