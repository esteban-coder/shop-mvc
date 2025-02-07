package pe.estebancoder.solutions.shop.order.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.estebancoder.solutions.shop.shared.dto.CustomResponseDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderRequestDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderResponseDTO;
import pe.estebancoder.solutions.shop.order.service.OrderService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequestDTO request) throws Exception{
        OrderResponseDTO orderDTO = orderService.create(request);
        CustomResponseDTO<OrderResponseDTO> responseDTO = new CustomResponseDTO<>();
        responseDTO.setData(orderDTO);
        responseDTO.setTimestamp(LocalDateTime.now());
        responseDTO.setStatus(HttpStatus.CREATED.name());
        responseDTO.setUri("/api/v1/orders/" + orderDTO.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<OrderResponseDTO> cancelOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.cancelOrder(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }
}
