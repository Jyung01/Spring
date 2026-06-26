package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider provider;

    @Test
    void createToken() {

        User user = User.builder()
                .userid("a101")
                .name("홍길동")
                .birth("2001-11-11")
                .age(26)
                .role("ADMIN")
                .build();

        String access = provider.createToken(user, 1);
        String refresh = provider.createToken(user, 5);
        log.info(access);
        log.info(refresh);
    }
    /*
    eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGRuZDk4OTVAZ21haWwuY29tIiwiaWF0IjoxNzgyMzY5ODIyLCJleHAiOjE3ODI0NTYyMjIsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.oLgOnEdS2eAdwyokhhqKE1yI3DcjcHjSBBFV3wpNehI
     */

    @Test
    void getClaims() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGRuZDk4OTVAZ21haWwuY29tIiwiaWF0IjoxNzgyMzY5ODIyLCJleHAiOjE3ODI0NTYyMjIsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.oLgOnEdS2eAdwyokhhqKE1yI3DcjcHjSBBFV3wpNehI";

        Claims claims = provider.getClaims(token);

        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        log.info("username: {}", username);
        log.info("role: {}", role);

    }

    @Test
    void getAuthentication() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGRuZDk4OTVAZ21haWwuY29tIiwiaWF0IjoxNzgyMzY5ODIyLCJleHAiOjE3ODI0NTYyMjIsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.oLgOnEdS2eAdwyokhhqKE1yI3DcjcHjSBBFV3wpNehI";

        Authentication authentication = provider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        //User user = details.getUser();

        log.info(user);

    }

    @Test
    void validateToken() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGRuZDk4OTVAZ21haWwuY29tIiwiaWF0IjoxNzgyMzY5ODIyLCJleHAiOjE3ODI0NTYyMjIsInVzZXJuYW1lIjoiYTEwMSIsInJvbGUiOiJBRE1JTiJ9.oLgOnEdS2eAdwyokhhqKE1yI3DcjcHjSBBFV3wpNehI";

        provider.validateToken(token);

    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecret() {
    }
}