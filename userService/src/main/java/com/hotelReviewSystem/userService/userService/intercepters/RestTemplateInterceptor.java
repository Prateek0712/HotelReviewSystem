package com.hotelReviewSystem.userService.userService.intercepters;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import java.io.IOException;


//durgesh didnt mention it but i give it due to avoid  some risk
@Configuration
@Component
//this is rest template interceptor which extends "clienthttoRequestInterceptor " interface
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {


    private OAuth2AuthorizedClientManager clientManager;

    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager)
    {
        this.clientManager=manager;
    }
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        //here the registration id is same as that  we declare in registration in yml file
        String token= clientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();

        request.getHeaders().add("Authorization", "Bearer "+token);

        return execution.execute(request,body);
    }
}
