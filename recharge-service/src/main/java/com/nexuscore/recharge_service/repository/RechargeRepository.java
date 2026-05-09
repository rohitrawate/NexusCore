package com.nexuscore.recharge_service.repository;


import com.nexuscore.recharge_service.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
}