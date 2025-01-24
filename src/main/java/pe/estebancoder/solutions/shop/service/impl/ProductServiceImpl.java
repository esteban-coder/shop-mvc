package pe.estebancoder.solutions.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.dto.UpdateStockRequestDTO;
import pe.estebancoder.solutions.shop.entity.OrderEntity;
import pe.estebancoder.solutions.shop.entity.ProductEntity;
import pe.estebancoder.solutions.shop.mapper.ProductMapper;
import pe.estebancoder.solutions.shop.repository.ProductRepository;
import pe.estebancoder.solutions.shop.service.ProductService;

import java.util.List;

import static pe.estebancoder.solutions.shop.mapper.ProductMapper.mapToDto;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());

        return mapToDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO updateStockRequestDTO) {
        return null;
    }

    @Override
    public boolean validateStock(Long id, Integer quantity) {
        return false;
    }



}
