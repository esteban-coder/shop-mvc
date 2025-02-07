package pe.estebancoder.solutions.shop.service;

import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.dto.UpdateStockRequestDTO;

import java.util.List;

public interface ProductService extends GenericService<ProductResponseDTO, ProductRequestDTO> {

    ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO updateStockRequestDTO);
    boolean validateStock(Long id, Integer quantity);
}
