package pe.estebancoder.solutions.shop.product.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.estebancoder.solutions.shop.shared.mapper.AbstractMapper;
import pe.estebancoder.solutions.shop.product.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.product.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.product.entity.ProductEntity;

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
