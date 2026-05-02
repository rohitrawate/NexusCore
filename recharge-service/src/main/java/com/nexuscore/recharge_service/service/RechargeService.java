package com.nexuscore.recharge_service.service;

import com.nexuscore.recharge_service.client.UserClient1;
import com.nexuscore.recharge_service.dto.RechargeRequestDTO;
import com.nexuscore.recharge_service.dto.RechargeResponseDTO;
import com.nexuscore.recharge_service.entity.Recharge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RechargeService {

    private final RechargeRepository rechargeRepository;
    private final UserClient1 userClient;

    public RechargeResponseDTO createRecharge(RechargeRequestDTO request) {

        log.info("Processing recharge for userId: {}", request.getUserId());

        boolean userExists = userClient.validateUser(request.getUserId());

        if (!userExists) {
            throw new RuntimeException("User does not exist");
        }

        Recharge recharge = Recharge.builder()
                .userId(request.getUserId())
                .amount(request.getAmount())
                .status("SUCCESS")
                .build();

        Recharge saved = rechargeRepository.save(recharge);

        return mapToResponse(saved);
    }

    private RechargeResponseDTO mapToResponse(Recharge recharge) {
        return RechargeResponseDTO.builder()
                .id(recharge.getId())
                .userId(recharge.getUserId())
                .amount(recharge.getAmount())
                .status(recharge.getStatus())
                .build();
    }
}