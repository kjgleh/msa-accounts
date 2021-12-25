package me.kjgleh.msa.accounts.dto

import me.kjgleh.msa.accounts.entity.Account

data class SignupDto(
    val name: String,
    val password: String,
) {

    fun toAccount(): Account {
        return Account(
            name = this.name,
            password = this.password
        )
    }
}
