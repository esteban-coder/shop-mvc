package pe.estebancoder.solutions.shop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderItemResponseDTO {

    private Long id;

    private Long productId;

    private String productName;//mostrar de product

    private Integer quantity;

    private Double unitPrice;

    private Double subTotal;
}
