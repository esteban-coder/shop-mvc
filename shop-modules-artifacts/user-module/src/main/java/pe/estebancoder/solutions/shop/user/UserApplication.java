package pe.estebancoder.solutions.shop.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = {
        "pe.estebancoder.solutions.shop.shared"
})
public class UserApplication {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));



        SpringApplication.run(UserApplication.class, args);
    }

}
