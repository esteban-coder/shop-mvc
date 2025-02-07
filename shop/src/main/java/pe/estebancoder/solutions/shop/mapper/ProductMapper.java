package pe.estebancoder.solutions.shop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.entity.ProductEntity;
import pe.estebancoder.solutions.shop.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper extends AbstractMapper<ProductEntity, ProductRequestDTO, ProductResponseDTO> {

    public ProductMapper(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    public Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }

    @Override
    public Class<ProductResponseDTO> getDtoClass() {
        return ProductResponseDTO.class;
    }


}
