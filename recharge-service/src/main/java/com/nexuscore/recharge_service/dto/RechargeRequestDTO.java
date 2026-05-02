package com.nexuscore.recharge_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RechargeRequestDTO {

    private Long userId;
    private Double amount;
}
