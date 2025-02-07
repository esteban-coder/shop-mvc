package pe.estebancoder.solutions.shop.modules.user.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.estebancoder.solutions.shop.modules.user.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.modules.user.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.modules.user.entity.UserEntity;

import java.util.List;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserResponseDTO mapToDto(UserEntity user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserEntity mapToEntity(UserRequestDTO dto){
        return modelMapper.map(dto, UserEntity.class);
    }

    public List<UserResponseDTO> mapToListDto(List<UserEntity> lstE){
        return lstE.stream().map(this::mapToDto).toList();
    }

    public List<UserEntity> mapToListEntity(List<UserRequestDTO> lstD){
        return lstD.stream().map(this::mapToEntity).toList();
    }
}
