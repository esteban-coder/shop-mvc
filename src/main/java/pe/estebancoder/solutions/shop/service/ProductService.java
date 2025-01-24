package pe.estebancoder.solutions.shop.service;

import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.dto.UpdateStockRequestDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProduct(Long id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO product);
    void deleteProduct(Long id);
    ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO updateStockRequestDTO);
    boolean validateStock(Long id, Integer quantity);
}
