package pe.estebancoder.solutions.shop.mapper;

import pe.estebancoder.solutions.shop.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.entity.UserEntity;

import java.util.List;

public interface GenericMapper<E, Req, Resp> {

    Resp mapToDto(E e);


    E mapToEntity(Req req);


    List<Resp> mapToListDto(List<E> lstE);


    List<E> mapToListEntity(List<Req> lstD);

}
