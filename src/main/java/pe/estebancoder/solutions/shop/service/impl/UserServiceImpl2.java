package pe.estebancoder.solutions.shop.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.shop.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.dto.UserUpdateRequestDTO;
import pe.estebancoder.solutions.shop.mapper.UserMapper;
import pe.estebancoder.solutions.shop.repository.UserRepository;
import pe.estebancoder.solutions.shop.service.UserService;

//@Service
public class UserServiceImpl2 extends UserServiceImpl {

    public UserServiceImpl2(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        super(userRepository, userMapper, passwordEncoder);
    }

    @Override
    public UserResponseDTO getById(Long id) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(7L);
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setEmail("john.doe@gmail.com");
        dto.setActive(true);
        return dto;
    }

}
