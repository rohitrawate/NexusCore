package com.nexuscore.recharge_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//public interface UserClient {
//}
@FeignClient(name = "User-service")
public interface UserClient {

    @GetMapping("/users/{id}")
    Object getUser(@PathVariable Long id);
}