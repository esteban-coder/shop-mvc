package pe.estebancoder.solutions.shop.modules.user.service;

import pe.estebancoder.solutions.shop.modules.user.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.modules.user.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.modules.user.dto.UserUpdateRequestDTO;
import pe.estebancoder.solutions.shop.shared.service.GenericService;

import java.util.Optional;

public interface UserService extends GenericService<UserResponseDTO, UserRequestDTO> {

    UserResponseDTO update(Long id, UserUpdateRequestDTO dto);
    boolean validateUser(Long id);
    Optional<UserResponseDTO> getUserByEmail(String email);
}
