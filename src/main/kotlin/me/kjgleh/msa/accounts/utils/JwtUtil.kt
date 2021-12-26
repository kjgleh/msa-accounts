package me.kjgleh.msa.accounts.utils

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class JwtUtil {

    companion object {
        const val KEY = "2227f63f-8199-4497-99fa-df3e8ce764c0"
        const val ISSUER = "kjgleh"
        val now: LocalDateTime = LocalDateTime.now()
    }

    fun issue(uuid: UUID): String {
        return Jwts.builder()
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .setIssuer(ISSUER)
            .setIssuedAt(now.toDate())
            .setExpiration(now.plusMinutes(30L).toDate())
            .signWith(SignatureAlgorithm.HS256, KEY)
            .setClaims(mapOf("uuid" to uuid))
            .compact()
    }

    fun LocalDateTime.toDate(): Date =
        Date.from(this.atZone(ZoneId.systemDefault()).toInstant())
}
