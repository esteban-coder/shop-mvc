package pe.estebancoder.solutions.shop.modules.order.dto;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

    private Long productId;

    private Integer quantity;
}
