package akeir.discontinued.order.kafka;

import akeir.order.model.Order;
import akeir.order.repository.OrderRepository;
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
    public void processOrder(Order order) 
    {
        double total = order.getItems().size() * 10.0; //TODO: Calc logic should be enhanced
        order.setTotal(total);
        
        // Save
        orderRepository.save(order);
        
        // Send to topic "processed-orders"
        orderProducer.sendOrder(order);
    }
}
