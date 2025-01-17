package com.hotelReviewSystem.Gateway.ApiGateway.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger= LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public ResponseEntity login(
            @RegisteredOAuth2AuthorizedClient("okta")OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
            ){

        //email
        logger.info("user email: "+ user.getEmail());
        AuthResponse authResponse= AuthResponse.builder()
                .userId(user.getEmail())
                .accessToken(client.getAccessToken().getTokenValue())
                .refreshToken(client.getRefreshToken().getTokenValue())
                .expireAt(client.getAccessToken().getExpiresAt().getEpochSecond())
                .authorities(user.getAuthorities().stream().map(grantedAuthority -> {
                    return grantedAuthority.getAuthority();
                }).collect(Collectors.toList()))
                .build();

        return new ResponseEntity(authResponse, HttpStatus.OK);
    }
}
