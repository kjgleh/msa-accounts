package me.kjgleh.msa.accounts.dto

import me.kjgleh.msa.accounts.entity.Account

data class AccountDto(
    val name: String,
) {

    companion object {
        fun of(account: Account): AccountDto {
            return AccountDto(
                name = account.name
            )
        }
    }
}
