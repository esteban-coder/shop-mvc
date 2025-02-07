package pe.estebancoder.solutions.shop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductRequestDTO {

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;
}
