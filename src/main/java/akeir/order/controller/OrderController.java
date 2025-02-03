package akeir.order.controller;

import akeir.order.model.Order;
import akeir.order.service.OrderService;
import akeir.order.service.ProductService;
import jakarta.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    
    public OrderController(OrderService orderService) 
    {
        this.orderService = orderService;
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
        ProductService prdSrvInstance = ProductService.getInst();
        prdSrvInstance.saveProducts(order);
    	
        Order savedOrder = orderService.createOrder(order);
        prdSrvInstance.setOrderRefIds(savedOrder);
        prdSrvInstance.saveProducts(savedOrder);

        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> getAllOrders() 
    {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    
    @GetMapping("/list/ready")
    public ResponseEntity<List<Order>> getAllReadyOrders()
    {
    	return ResponseEntity.ok(orderService.getAllReadyOrders());
    }
}
