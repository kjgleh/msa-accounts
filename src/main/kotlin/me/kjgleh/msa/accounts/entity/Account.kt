package me.kjgleh.msa.accounts.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "msa_accounts")
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val uuid: String = UUID.randomUUID().toString(),

    val email: String,

    val password: String,
): BaseEntity()