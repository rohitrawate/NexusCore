package com.nexuscore.recharge_service.controller;


import com.nexuscore.recharge_service.dto.RechargeRequestDTO;
import com.nexuscore.recharge_service.dto.RechargeResponseDTO;
import com.nexuscore.recharge_service.service.RechargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recharges")
@RequiredArgsConstructor
public class RechargeController {

    private final RechargeService rechargeService;

    @PostMapping
    public RechargeResponseDTO createRecharge(
            @RequestBody RechargeRequestDTO request) {

        return rechargeService.createRecharge(request);
    }
}
