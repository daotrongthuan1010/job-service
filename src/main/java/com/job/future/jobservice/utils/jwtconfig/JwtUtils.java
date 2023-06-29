package com.job.future.jobservice.utils.jwtconfig;

import com.job.future.jobservice.model.User;
import com.job.future.jobservice.service.serviceIpm.UserDetailsServiceIpm;
import com.job.future.jobservice.utils.SecretKeyGenerator;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtUtils {

    private String username = "User_name";

    @Value("${EXPIRE_TIME}")
    private int EXPIRE_TIME;

    public String generateTokenLogin(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();

        JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
        builder.expirationTime(generateExpirationDate());
        JWTClaimsSet claimsSet = builder
                .subject(userPrincipal.getUsername())
                        .issueTime(new Date())
                                .expirationTime(new Date((new Date()).getTime() + EXPIRE_TIME))
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

    }

    private JWTClaimsSet getClaimsFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(generateSecretKey().getEncoded());
            if (signedJWT.verify(verifier)) {
                return signedJWT.getJWTClaimsSet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRE_TIME);
    }

    private Date getExpirationDateFromToken(String token) {
        JWTClaimsSet claims = getClaimsFromToken(token);
        if (claims != null) {
            return claims.getExpirationTime();
        }
        return null;
    }

    public String getUsernameFromToken(String token) {
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            if (claims != null) {
                String username = claims.getStringClaim(USERNAME);
                return username;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private SecretKey generateSecretKey() {
        return SecretKeyGenerator.generateSecretKey();
    }

    private byte[] generateShareSecret() {
        SecretKey secretKey = generateSecretKey();
        if (secretKey != null) {
            return secretKey.getEncoded();
        } else {
            throw new RuntimeException("Failed to generate SECRET_KEY");
        }
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration != null && expiration.before(new Date());
    }

    public Boolean validateTokenLogin(String token) {
        if (token == null || token.trim().isEmpty()) {
            return false;
        }
        String username = getUsernameFromToken(token);
        return username != null && !username.isEmpty() && !isTokenExpired(token);
    }

}