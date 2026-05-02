package com.nexuscore.recharge_service.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RechargeResponseDTO {

    private Long id;
    private Long userId;
    private Double amount;
    private String status;
}