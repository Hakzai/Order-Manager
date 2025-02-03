package akeir.order.service;

import akeir.order.model.Order;
import akeir.order.model.Product;
import akeir.order.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) 
    {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) 
    {
        order.setTotal(calculateTotal(order.getItems()));
        order.setDeliveryRequiredDate(calculateDeliveryDate(order.getRegisterDate()));
        order.setOrderReady(true);
        return orderRepository.save(order);
    }

	public List<Order> getAllOrders() 
    {
        return orderRepository.findAll();
    }
	
	public List<Order> getAllReadyOrders()
	{
		return orderRepository.findByIsOrderReady(true);
	}

    private double calculateTotal(List<Product> items) 
    {
        double total = 0.00;
    	
    	for(Product product : items)
        {
        	System.out.println(product.toString());
    		total += product.getUnitPrice() * product.getOrderedQuantity();
        }
    	
    	System.out.println("TOTAL " + total);
    	return total;
    }

    private LocalDateTime calculateDeliveryDate(LocalDateTime registerDate) 
    {
    	return registerDate.plusDays(7);
    }
}
