package akeir.order.service;

import akeir.order.model.Order;
import akeir.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

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
        double total = calculateTotal(order.getItems());
        order.setTotal(total);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() 
    {
        return orderRepository.findAll();
    }

    private double calculateTotal(List<String> items) 
    {
        return items.size() * 10.0;  //TODO: Make a basic pricing logic
    }
}
