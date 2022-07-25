package com.natours.natoursbackend.services;

import com.natours.natoursbackend.exceptions.InvalidRefreshTokenException;
import com.natours.natoursbackend.models.RefreshToken;
import com.natours.natoursbackend.repositories.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());
        return refreshTokenRepository.save(refreshToken);
    }

    public void validateRefreshToken(String refreshToken) {
        refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> new InvalidRefreshTokenException("Invalid Refresh Token!"));
    }

    //for logout:
    public void deleteRefreshToken(String refreshToken) {
        refreshTokenRepository.deleteByToken(refreshToken);
    }
}
