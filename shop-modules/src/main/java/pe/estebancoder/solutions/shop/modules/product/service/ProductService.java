package pe.estebancoder.solutions.shop.modules.product.service;

import pe.estebancoder.solutions.shop.modules.product.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.modules.product.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.modules.product.dto.UpdateStockRequestDTO;
import pe.estebancoder.solutions.shop.shared.service.GenericService;

public interface ProductService extends GenericService<ProductResponseDTO, ProductRequestDTO> {

    ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO updateStockRequestDTO);
    boolean validateStock(Long id, Integer quantity);
}
