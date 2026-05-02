package com.nexuscore.recharge_service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient1 {
    //use RestTemplate (simple first)  Later -> Feign
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean validateUser(Long userId) {

        try {
            String url = "http://localhost:8081/users/" + userId;

            ResponseEntity<Object> response =
                    restTemplate.getForEntity(url, Object.class);

            return response.getStatusCode().is2xxSuccessful();

        } catch (Exception e) {
            return false;
        }
    }
}