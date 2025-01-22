package pe.estebancoder.solutions.shop.dto;

import lombok.Data;
import pe.estebancoder.solutions.shop.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDTO {

    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;
    private List<OrderItemResponseDTO> items;
}
