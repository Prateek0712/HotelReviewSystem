package com.hotelReviewSystem.Gateway.ApiGateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity    //becoz we  are  not using normal spring web we are using  web flux so thats why using webfluxsecurity
public class SecurityConfig {


    //as this web flux so that why it will return security web filter chain instead of securityfilterchain
    // and will pass ServerHttpsecurity instead httpSecucity

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity)
    {
        httpSecurity
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Client()
                .and()
                .oauth2ResourceServer()
                .jwt();

        return httpSecurity.build();


        //some method are deprecated  but can still work until  full removal
    }

}
