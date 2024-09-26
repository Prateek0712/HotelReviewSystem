package com.hotelReviewSystem.userService.userService.config;


import com.hotelReviewSystem.userService.userService.intercepters.RestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class config {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        RestTemplate template = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptorList=new ArrayList<>();
        interceptorList.add(new RestTemplateInterceptor(clientManager(clientRegistrationRepository,
                oAuth2AuthorizedClientRepository)));

        template.setInterceptors(interceptorList);
        return template;
    }



    @Bean
    public OAuth2AuthorizedClientManager clientManager(
            ClientRegistrationRepository clientRepo,
            OAuth2AuthorizedClientRepository oauth2Repo
    ){
        OAuth2AuthorizedClientProvider provider= OAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials().build();

        DefaultOAuth2AuthorizedClientManager clientManager =new DefaultOAuth2AuthorizedClientManager(clientRepo,oauth2Repo);

        clientManager.setAuthorizedClientProvider(provider);


       return clientManager;
    }
}
