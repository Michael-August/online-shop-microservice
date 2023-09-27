package com.augustshop.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augustshop.orderservice.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
