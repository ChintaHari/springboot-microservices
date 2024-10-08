package com.example.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.order_service.entity.Order;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
