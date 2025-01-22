package pe.estebancoder.solutions.shop.dto;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

    private Long productId;

    private Integer quantity;
}
