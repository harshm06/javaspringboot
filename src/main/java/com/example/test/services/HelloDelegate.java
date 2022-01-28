package com.example.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloDelegate {
    @Autowired
    RestTemplate restTemplate;

    public String callHelloFunc()
    {
        String response = restTemplate.exchange("http://childapp/getConsulData/",HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return response;
    }
}
