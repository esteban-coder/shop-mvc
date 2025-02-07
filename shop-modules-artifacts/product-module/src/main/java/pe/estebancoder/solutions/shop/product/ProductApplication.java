package pe.estebancoder.solutions.shop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = {
        "pe.estebancoder.solutions.shop.shared"
})
public class ProductApplication {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));



        SpringApplication.run(ProductApplication.class, args);
    }

}
