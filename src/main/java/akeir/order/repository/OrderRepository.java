package akeir.order.repository;

import akeir.order.model.Order;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findByIsOrderReady(boolean isReady);
}
