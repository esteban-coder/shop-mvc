package pe.estebancoder.solutions.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.estebancoder.solutions.shop.mapper.UserMapper;
import pe.estebancoder.solutions.shop.repository.UserRepository;
import pe.estebancoder.solutions.shop.service.UserService;
import pe.estebancoder.solutions.shop.service.impl.UserServiceImpl;

//@Configuration
public class ServiceConfiguration {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public ServiceConfiguration(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    //@Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository, userMapper, passwordEncoder);
        //return new UserServiceImpl2(userRepository, userMapper, passwordEncoder);
    }

}
