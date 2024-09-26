package com.hotelReviewSystem.userService.userService.intercepters;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Component
@Configuration
//this is the interceptor for feign client which implement "requestInterceptor interface"
public class FeignClientInterceptor implements RequestInterceptor {

    private OAuth2AuthorizedClientManager manager;   //this manager that hold impo Oauth2 method


    //we need to prrovide implementation  for apply method
    @Override
    public void apply(RequestTemplate requestTemplate) {

        //here the registration id is same as that  we declare in registration in yml file
        String token= manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
        // this token will be our logged in use token which we will pass to header of feign client client
        requestTemplate.header("Authorization", "Bearer "+token);
    }
}
