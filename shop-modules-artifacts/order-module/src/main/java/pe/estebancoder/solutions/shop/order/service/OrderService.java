package pe.estebancoder.solutions.shop.order.service;

import pe.estebancoder.solutions.shop.order.dto.OrderRequestDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderResponseDTO;
import pe.estebancoder.solutions.shop.order.exception.InvalidOrderStatusException;
import pe.estebancoder.solutions.shop.shared.service.GenericService;

public interface OrderService extends GenericService<OrderResponseDTO, OrderRequestDTO> {

    OrderResponseDTO cancelOrder(Long id)  throws InvalidOrderStatusException;
    // OrderResponseDTO preCreate(OrderRequestDTO dto);
}
