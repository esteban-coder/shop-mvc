package pe.estebancoder.solutions.shop.product.service;

import pe.estebancoder.solutions.shop.product.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.product.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.product.dto.UpdateStockRequestDTO;
import pe.estebancoder.solutions.shop.shared.service.GenericService;

public interface ProductService extends GenericService<ProductResponseDTO, ProductRequestDTO> {

    ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO updateStockRequestDTO);
    boolean validateStock(Long id, Integer quantity);
}
