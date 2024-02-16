package kea.exercise.productorderexercise.controllers;

import kea.exercise.productorderexercise.models.OrderLine;
import kea.exercise.productorderexercise.repositories.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderLineController {

    private OrderRepository orderRepository;

    public OrderLineController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<OrderLine> getAll(){
        return orderRepository.findAll();
    }
}
