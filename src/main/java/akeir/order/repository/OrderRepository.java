package akeir.order.repository;

import akeir.order.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
