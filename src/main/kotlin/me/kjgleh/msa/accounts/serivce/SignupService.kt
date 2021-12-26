package me.kjgleh.msa.accounts.serivce

import me.kjgleh.msa.accounts.dto.AccountDto
import me.kjgleh.msa.accounts.dto.SignupDto
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
    fun signup(signupDto: SignupDto): AccountDto {
        val signupDtoWithPasswordEncoded = signupDto.copy(
            password = passwordEncoder.encode(signupDto.password)
        )
        val account =
            accountRepository.save(signupDtoWithPasswordEncoded.toAccount())
        return AccountDto.of(account)
    }
}
