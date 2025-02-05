package pe.estebancoder.solutions.shop.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.estebancoder.solutions.shop.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.dto.UpdateStockRequestDTO;
import pe.estebancoder.solutions.shop.entity.OrderEntity;
import pe.estebancoder.solutions.shop.entity.ProductEntity;
import pe.estebancoder.solutions.shop.exception.ProductNotFoundException;
import pe.estebancoder.solutions.shop.mapper.ProductMapper;
import pe.estebancoder.solutions.shop.repository.ProductRepository;
import pe.estebancoder.solutions.shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        //return productMapper.mapToListDto(productRepository.findAll());
        return productRepository.findByActiveTrue()
                .stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {
        ProductEntity product = findProductOrThrow(id);
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        return productMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        ProductEntity product = findProductOrThrow(id);
        product.setActive(false);
        productRepository.save(product);
    }

    @Override
    public ProductResponseDTO updateStock(Long id, UpdateStockRequestDTO request) {
        ProductEntity product = findProductOrThrow(id);

        int newStock = request.quantity() + product.getStockQuantity();
        if (newStock < 0) {
            //log.error("New stock cannot be negative", e);
            throw new RuntimeException("New stock cannot be negative");
        }
        product.setStockQuantity(newStock);
        return productMapper.mapToDto(productRepository.save(product));
    }

    @Override
    public boolean validateStock(Long id, Integer quantity) {
        ProductEntity product = findProductOrThrow(id);
        return product.getStockQuantity() >= quantity;
    }

}