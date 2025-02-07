package pe.estebancoder.solutions.shop.dto;

import lombok.Data;
import pe.estebancoder.solutions.shop.entity.UserEntity;

import java.util.List;

@Data
public class OrderRequestDTO {

    private Long userId;

    private List<OrderItemRequestDTO> items;

}
