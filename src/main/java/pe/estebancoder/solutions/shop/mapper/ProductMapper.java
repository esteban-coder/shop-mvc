package pe.estebancoder.solutions.shop.mapper;

import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.entity.ProductEntity;

public class ProductMapper {

    public static ProductResponseDTO mapToDto(ProductEntity product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getActive()
        );
    }


}
