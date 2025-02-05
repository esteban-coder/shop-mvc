package pe.estebancoder.solutions.shop.service;

import pe.estebancoder.solutions.shop.dto.OrderRequestDTO;
import pe.estebancoder.solutions.shop.dto.OrderResponseDTO;

public interface OrderService extends GenericService<OrderResponseDTO, OrderRequestDTO>{

    OrderResponseDTO cancelOrder(Long id);
}
