package pe.estebancoder.solutions.shop.mapper;

import org.modelmapper.ModelMapper;
import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.entity.ProductEntity;

import java.util.List;

public abstract class AbstractMapper<E, Req, Resp> /*implements GenericMapper<E, Req, Resp>*/ {

    private final ModelMapper modelMapper;

    public AbstractMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Resp mapToDto(E product) {
        return modelMapper.map(product, getDtoClass());
    }

    public E mapToEntity(Req dto){
        return modelMapper.map(dto, getEntityClass());
    }

    public List<Resp> mapToListDto(List<E> lstE){
        return lstE.stream().map(this::mapToDto).toList();
    }

    public List<E> mapToListEntity(List<Req> lstD){
        return lstD.stream().map(this::mapToEntity).toList();
    }

    public abstract Class<E> getEntityClass();
    public abstract Class<Resp> getDtoClass();

}
