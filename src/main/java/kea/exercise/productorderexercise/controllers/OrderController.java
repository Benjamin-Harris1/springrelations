package kea.exercise.productorderexercise.controllers;

import kea.exercise.productorderexercise.models.Order;
import kea.exercise.productorderexercise.repositories.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
}
