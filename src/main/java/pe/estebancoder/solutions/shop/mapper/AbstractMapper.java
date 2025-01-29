package pe.estebancoder.solutions.shop.mapper;

import org.modelmapper.ModelMapper;
import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.entity.ProductEntity;

import java.util.List;

public abstract class AbstractMapper<E, Req, Resp> implements GenericMapper<E, Req, Resp> {
/*
    private final ModelMapper modelMapper;

    public AbstractMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductResponseDTO mapToDto(ProductEntity product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }

    public ProductEntity mapToEntity(ProductRequestDTO dto){
        return modelMapper.map(dto, ProductEntity.class);
    }

    public List<ProductResponseDTO> mapToListDto(List<ProductEntity> lstE){
        return lstE.stream().map(this::mapToDto).toList();
    }

    public List<ProductEntity> mapToListEntity(List<ProductRequestDTO> lstD){
        return lstD.stream().map(this::mapToEntity).toList();
    }
*/
}
