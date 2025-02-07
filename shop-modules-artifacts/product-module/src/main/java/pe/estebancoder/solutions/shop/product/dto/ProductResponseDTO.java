package pe.estebancoder.solutions.shop.product.dto;

import lombok.Data;

@Data
public class ProductResponseDTO
{
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Boolean active;
}
