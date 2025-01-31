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
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO request) {
        ProductEntity product = productMapper.mapToEntity(request);
        return productMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        ProductEntity product = findProductOrThrow(id);
        return productMapper.mapToDto(product);
    }

    private ProductEntity findProductOrThrow(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return productMapper.mapToListDto(productRepository.findAll());
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO product) {
        return null;
    }

    @Override
    public void delete(Long id) {

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
