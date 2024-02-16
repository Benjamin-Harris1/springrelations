package kea.exercise.productorderexercise.repositories;

import kea.exercise.productorderexercise.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public InitData(ProductRepository productRepository){
        this.productRepository = productRepository;
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
    }
}
