package kea.exercise.productorderexercise.controllers;

import kea.exercise.productorderexercise.models.OrderLine;
import kea.exercise.productorderexercise.repositories.OrderLineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderLineController {

    private OrderLineRepository orderRepository;

    public OrderLineController(OrderLineRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<OrderLine> getAll(){
        return orderRepository.findAll();
    }

    @PostMapping
    public OrderLine createOrderLine(@RequestBody OrderLine orderLine){
        return orderRepository.save(orderLine);
    }
}
