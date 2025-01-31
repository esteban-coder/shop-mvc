package pe.estebancoder.solutions.shop.service;

import pe.estebancoder.solutions.shop.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.dto.UserUpdateRequestDTO;

import java.util.List;

public interface UserService extends GenericService<UserResponseDTO, UserRequestDTO> {

    UserResponseDTO update(Long id, UserUpdateRequestDTO dto);

}
