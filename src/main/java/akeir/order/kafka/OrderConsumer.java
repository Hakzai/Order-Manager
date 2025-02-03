package akeir.order.kafka;

import akeir.order.model.Order;
import akeir.order.model.Product;
import akeir.order.repository.OrderRepository;
import akeir.order.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderConsumer(OrderRepository orderRepository, OrderProducer orderProducer) 
    {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    @KafkaListener(topics = "new-orders", groupId = "order-group")
    public void consume(Order order) {
        System.out.println("📥 Received Order: " + order);
    }
    
    @KafkaListener(topics = "new-orders", groupId = "order-group")
    public void processOrder(Order order) 
    {
    	order.setTotal(calculateTotal(order.getItems()));
        order.setDeliveryRequiredDate(calculateDeliveryDate(order.getRegisterDate()));
        
        ProductService prdSrvInstance = ProductService.getInst();
        prdSrvInstance.saveProducts(order);
        
        // Save order and reference it to products
        orderRepository.save(order);
        prdSrvInstance.setOrderRefIds(order);
        prdSrvInstance.saveProducts(order);
        
        // Send to topic "processed-orders"
        orderProducer.sendOrder(order);
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
