package kea.exercise.productorderexercise.repositories;

import kea.exercise.productorderexercise.models.Order;
import kea.exercise.productorderexercise.models.OrderLine;
import kea.exercise.productorderexercise.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;

    public InitData(ProductRepository productRepository, OrderLineRepository orderLineRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    public void run(String... args){
        System.out.println("InitData is running");

        Product kyllingebryst = new Product("Kyllingebryst", "500g", 24.95, "123456789");
        Product tarteletter = new Product("Tarteletter", "50g", 14.95, "222884556");
        Product rejer = new Product("Rejer", "500g", 49.95, "234567891");
        Product snickers = new Product("Snickers", "20g", 9.95, "345678912");
        productRepository.save(kyllingebryst);
        productRepository.save(tarteletter);
        productRepository.save(rejer);
        productRepository.save(snickers);

        OrderLine line1 = new OrderLine(kyllingebryst, 10);
        OrderLine line2 = new OrderLine(kyllingebryst, 5);
        OrderLine line3 = new OrderLine(tarteletter, 10);
        OrderLine line4 = new OrderLine(tarteletter, 2);
        OrderLine line5 = new OrderLine(snickers, 1);

        Order order = new Order(LocalDate.now(), true, List.of(line4, line2, line5));
        orderRepository.save(order);

    }
}
