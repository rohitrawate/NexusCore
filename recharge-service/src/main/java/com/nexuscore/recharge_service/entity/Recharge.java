package com.nexuscore.recharge_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recharges")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double amount;
    private String status;
}