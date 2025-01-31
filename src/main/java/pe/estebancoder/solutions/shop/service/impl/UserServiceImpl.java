package pe.estebancoder.solutions.shop.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.dto.UserUpdateRequestDTO;
import pe.estebancoder.solutions.shop.entity.UserEntity;
import pe.estebancoder.solutions.shop.mapper.UserMapper;
import pe.estebancoder.solutions.shop.repository.UserRepository;
import pe.estebancoder.solutions.shop.service.UserService;
import pe.estebancoder.solutions.shop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        //UserEntity user = userMapper.mapToEntity(request);

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return userMapper.mapToDto(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getById(Long id) {
        UserEntity user = findUserOrThrow(id);
        return userMapper.mapToDto(user);
    }

    private UserEntity findUserOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userMapper.mapToListDto(userRepository.findAll());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public UserResponseDTO update(Long id, UserUpdateRequestDTO dto) {
        UserEntity user = findUserOrThrow(id);
        if(!user.getEmail().equals(dto.getEmail()) && userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        return userMapper.mapToDto(userRepository.save(user));
    }
}
