package pe.estebancoder.solutions.shop.service;

import pe.estebancoder.solutions.shop.dto.OrderRequestDTO;
import pe.estebancoder.solutions.shop.dto.OrderResponseDTO;
import pe.estebancoder.solutions.shop.exception.InvalidOrderStatusException;

public interface OrderService extends GenericService<OrderResponseDTO, OrderRequestDTO>{

    OrderResponseDTO cancelOrder(Long id)  throws InvalidOrderStatusException;
    // OrderResponseDTO preCreate(OrderRequestDTO dto);
}
