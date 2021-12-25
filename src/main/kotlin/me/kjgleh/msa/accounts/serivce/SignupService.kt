package me.kjgleh.msa.accounts.serivce

import me.kjgleh.msa.accounts.dto.SignupDto
import me.kjgleh.msa.accounts.dto.AccountDto
import me.kjgleh.msa.accounts.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignupService(
    private val accountRepository: AccountRepository
) {

    @Transactional
    fun signup(signupDto: SignupDto): AccountDto {
        val account = accountRepository.save(signupDto.toAccount())
        return AccountDto.of(account)
    }
}
