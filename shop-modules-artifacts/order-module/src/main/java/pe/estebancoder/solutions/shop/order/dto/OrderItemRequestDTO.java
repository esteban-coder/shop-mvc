package pe.estebancoder.solutions.shop.order.dto;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

    private Long productId;

    private Integer quantity;
}
