package pe.estebancoder.solutions.shop.product.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.estebancoder.solutions.shop.shared.dto.CustomResponseDTO;
import pe.estebancoder.solutions.shop.product.dto.ProductRequestDTO;
import pe.estebancoder.solutions.shop.product.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.product.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestDTO request){
        ProductResponseDTO productDTO = productService.create(request);
        CustomResponseDTO<ProductResponseDTO> responseDTO = new CustomResponseDTO<>();
        responseDTO.setData(productDTO);
        responseDTO.setTimestamp(LocalDateTime.now());
        responseDTO.setStatus(HttpStatus.CREATED.name());
        responseDTO.setUri("/api/v1/products/" + productDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request){
        return ResponseEntity.ok(productService.update(id, request));
    }


}
