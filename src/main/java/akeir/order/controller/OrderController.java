package akeir.order.controller;

import akeir.order.kafka.OrderProducer;
import akeir.order.model.Order;
import akeir.order.repository.OrderRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderProducer orderProducer;
//	private final OrderRepository orderRepository;
//    
//    public OrderController(OrderProducer orderProducer, OrderRepository orderRepository) 
//    {
//        this.orderProducer = orderProducer;
//        this.orderRepository = orderRepository;
//    }
	
	public OrderController(OrderProducer orderProducer)
	{
		this.orderProducer = orderProducer;
	}
    
    @PostConstruct
    public void init() 
    {
        System.out.println("🚀 OrderController foi carregado!");
    }
    
    @GetMapping
    public String testEndpoint() 
    {
        return "Test Order Service :: Order service is running!";
    }
    
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) 
    {
    	orderProducer.sendOrder(order);
    	
    	return ResponseEntity.ok(order);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> getAllOrders() 
    {
        return null; //ResponseEntity.ok(orderRepository.findAll());
    }
}
