package pe.estebancoder.solutions.shop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = {
        "pe.estebancoder.solutions.shop.order",
        "pe.estebancoder.solutions.shop.user",
        "pe.estebancoder.solutions.shop.product",
        "pe.estebancoder.solutions.shop.shared"
})
public class OrderApplication {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));



        SpringApplication.run(OrderApplication.class, args);
    }

}
