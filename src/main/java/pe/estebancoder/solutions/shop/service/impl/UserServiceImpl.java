package pe.estebancoder.solutions.shop.service.impl;

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

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO request) {
        UserEntity user = userMapper.mapToEntity(request);
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
    public boolean update(Long id, UserRequestDTO dto) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean update(Long id, UserUpdateRequestDTO dto) {
        return false;
    }
}
