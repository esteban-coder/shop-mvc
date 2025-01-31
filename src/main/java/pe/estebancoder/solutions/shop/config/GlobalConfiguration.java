package pe.estebancoder.solutions.shop.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.estebancoder.solutions.shop.mapper.UserMapper;
import pe.estebancoder.solutions.shop.repository.UserRepository;
import pe.estebancoder.solutions.shop.service.UserService;
import pe.estebancoder.solutions.shop.service.impl.UserServiceImpl;

@Configuration
public class GlobalConfiguration {

    @Bean
    public ModelMapper modelMapper() {
//        var modelMapper = new ModelMapper();
//        modelMapper.registerModule(new RecordModule());
//        return modelMapper;

        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
