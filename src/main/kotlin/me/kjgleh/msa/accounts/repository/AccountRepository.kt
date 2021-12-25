package me.kjgleh.msa.accounts.repository

import me.kjgleh.msa.accounts.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long>