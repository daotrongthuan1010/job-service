package com.job.future.jobservice.utils.jwtconfig;

import com.job.future.jobservice.repository.UserRepository;
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
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtUtils {

    public static final String USERNAME = "username";

    @Value("${EXPIRE_TIME}")
    private int EXPIRE_TIME;

    public String generateTokenLogin(String username) {
        try {
            // Create HMAC signer
            JWSSigner signer = new MACSigner(generateShareSecret());
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .claim(USERNAME, username)
                    .expirationTime(generateExpirationDate())
                    .build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            // Apply the HMAC protection
            signedJWT.sign(signer);
            // Serialize to compact form, produces something like
            // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
            return signedJWT.serialize();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private JWTClaimsSet getClaimsFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(generateShareSecret());
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
                return claims.getStringClaim(USERNAME);
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