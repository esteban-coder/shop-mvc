package pe.estebancoder.solutions.shop.user.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.shop.user.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.user.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.user.dto.UserUpdateRequestDTO;
import pe.estebancoder.solutions.shop.user.entity.UserEntity;
import pe.estebancoder.solutions.shop.user.exception.EmailAlreadyExistsException;
import pe.estebancoder.solutions.shop.user.exception.UserNotFoundException;
import pe.estebancoder.solutions.shop.user.mapper.UserMapper;
import pe.estebancoder.solutions.shop.user.repository.UserRepository;
import pe.estebancoder.solutions.shop.user.service.UserService;

import java.util.List;
import java.util.Optional;

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
            throw new EmailAlreadyExistsException("Email ya registrado: " + request.getEmail());
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
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findByActiveTrue()
                .stream().map(userMapper::mapToDto).toList();
    }

    @Override
    public void delete(Long id) {
        UserEntity user = findUserOrThrow(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public UserResponseDTO update(Long id, UserUpdateRequestDTO dto) {
        UserEntity user = findUserOrThrow(id);
        if(!user.getEmail().equals(dto.getEmail()) && userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + dto.getEmail() );
        }
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        return userMapper.mapToDto(userRepository.save(user));
    }

    @Override
    public boolean validateUser(Long id) {
        return userRepository.findByIdAndActiveTrue(id).isPresent();
    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        return Optional.empty();
    }
}
