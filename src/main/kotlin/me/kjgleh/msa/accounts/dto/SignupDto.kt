package me.kjgleh.msa.accounts.dto

import me.kjgleh.msa.accounts.entity.Account

data class SignupDto(
    val email: String,
    val password: String,
) {

    fun toAccount(): Account {
        return Account(
            email = this.email,
            password = this.password
        )
    }
}
