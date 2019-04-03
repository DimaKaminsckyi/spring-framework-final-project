package com.basecamp.springframeworkfinalproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTeampleteConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
