package me.kjgleh.msa.accounts.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests() // 페이지 권한 설정
//            .antMatchers("/admin/**").hasRole("ADMIN")
//            .antMatchers("/accounts/**").hasRole("MEMBER")
            .anyRequest().permitAll()
// 로그인 설정
//            .and()
//            .formLogin()
//            .loginPage("/user/login")
//            .defaultSuccessUrl("/user/login/result") // 로그아웃 설정
//            .and().logout()
//            .logoutRequestMatcher(AntPathRequestMatcher("/user/logout"))
//            .logoutSuccessUrl("/user/logout/result")
//            .invalidateHttpSession(true) // 403 에러 핸들링
//            .and().exceptionHandling().accessDeniedPage("/user/denied")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}