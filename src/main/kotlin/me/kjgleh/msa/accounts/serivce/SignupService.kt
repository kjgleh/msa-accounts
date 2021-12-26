package me.kjgleh.msa.accounts.serivce

import me.kjgleh.msa.accounts.dto.SignupDto
import me.kjgleh.msa.accounts.entity.Account
import me.kjgleh.msa.accounts.repository.AccountRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignupService(
    private val accountRepository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun signup(signupDto: SignupDto): Account {
        val signupDtoWithPasswordEncoded = signupDto.copy(
            password = passwordEncoder.encode(signupDto.password)
        )
        return accountRepository.save(signupDtoWithPasswordEncoded.toAccount())
    }
}
