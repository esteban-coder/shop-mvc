package pe.estebancoder.solutions.shop.order.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.estebancoder.solutions.shop.order.entity.OrderEntity;
import pe.estebancoder.solutions.shop.order.entity.OrderItemEntity;
import pe.estebancoder.solutions.shop.order.entity.OrderStatus;
import pe.estebancoder.solutions.shop.order.dto.OrderItemRequestDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderItemResponseDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderRequestDTO;
import pe.estebancoder.solutions.shop.order.dto.OrderResponseDTO;
import pe.estebancoder.solutions.shop.order.exception.InsufficientStockException;
import pe.estebancoder.solutions.shop.order.exception.InvalidOrderStatusException;
import pe.estebancoder.solutions.shop.order.exception.OrderNotFoundException;
import pe.estebancoder.solutions.shop.order.exception.UserNotValidException;
import pe.estebancoder.solutions.shop.product.dto.ProductResponseDTO;
import pe.estebancoder.solutions.shop.product.dto.UpdateStockRequestDTO;
import pe.estebancoder.solutions.shop.order.repository.OrderRepository;
import pe.estebancoder.solutions.shop.order.service.OrderService;
import pe.estebancoder.solutions.shop.product.service.ProductService;
import pe.estebancoder.solutions.shop.user.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
//@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

//    public OrderResponseDTO preCreate(OrderRequestDTO dto){
//        //logica inicial
//        return create(dto);
//    }

    @Override
    @Transactional()
    public OrderResponseDTO create(OrderRequestDTO dto) {
        // 1. Validar Usuario
        if(!userService.validateUser(dto.getUserId())){
            throw new UserNotValidException("Usuario no valido: "+ dto.getUserId());
        }

        // 2. Crear orden (pedido)
        OrderEntity order = new OrderEntity();
        order.setUserId(dto.getUserId());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        double totalAmount = 0;

        // 2.1 Agregar los items de la orden y calcular el total de la compra
        for(OrderItemRequestDTO itemDto : dto.getItems()) {
            // 2.1.1. Validar producto y stock del item
            if(!productService.validateStock(itemDto.getProductId(), itemDto.getQuantity())){
                throw new InsufficientStockException("Stock insuficiente para el producto "+itemDto.getProductId());
            }

            // 2.1.2. Obtener producto para saber el precio
            ProductResponseDTO productDto = productService.getById(itemDto.getProductId());

            // 2.1.3. Crear el item de la orden (calculo del subtotal)
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setProductId(itemDto.getProductId());
            // orderItem.setProductName(itemDto.getProductName());
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setUnitPrice(productDto.getPrice());
            orderItem.setSubTotal(itemDto.getQuantity()*productDto.getPrice());

            order.getItems().add(orderItem);

            totalAmount += orderItem.getSubTotal();
        }

        // 2.2 el total de la orden
        order.setTotalAmount(totalAmount);

        // 2.3 actulizar el stock de productos
        for(OrderItemRequestDTO itemDto : dto.getItems()) {
            UpdateStockRequestDTO updateStock = new UpdateStockRequestDTO(itemDto.getQuantity());
            productService.updateStock(itemDto.getProductId(), updateStock);
        }

        // 2.4 cambiar estado de la orden
        order.setStatus(OrderStatus.CONFIRMED);

        OrderEntity orderEntity = orderRepository.save(order);

        // logica de negocio
        // usar la orden que acabas de grabar en BD

        // READ_UNCOMIT =>> LECTURA SUCIAS
        // READ_COMMITED => LA TX QUE CREA ESA SOLA PUEDER
        // SERIABLIZABE => NADIE PUEDE VER ESA FILA EN BD

//        if(1==1){
//            throw new UserNotValidException("****************** Error ******************");
//        }

        return mapToDto(orderEntity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderResponseDTO update(Long id, OrderRequestDTO dto) {
        return null;
    }

    @Override
    public OrderResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public OrderResponseDTO cancelOrder(Long id) {
        //startTransaction()
        // 1. buscar la orden
        OrderEntity order = findOrderOrThrow(id);

        // 2. valida el estatus
        if(!order.getStatus().equals(OrderStatus.PENDING)){
            throw new InvalidOrderStatusException("Solo se pueden cancelar ordenes pendientes");
        }

        // 3. Restaurar el stock
        for (OrderItemEntity item : order.getItems()) {
            UpdateStockRequestDTO updateStock = new UpdateStockRequestDTO(item.getQuantity());
            productService.updateStock(item.getProductId(), updateStock);
        }

        // 4. cambiar el esteado de la orden
        order.setStatus(OrderStatus.CANCELLED);

        return mapToDto(orderRepository.save(order));
        //commit
    }

    private OrderEntity findOrderOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + id));
    }

    private OrderResponseDTO mapToDto(OrderEntity order){
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setOrderDate(order.getOrderDate());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus().name());

        List<OrderItemResponseDTO> itemsDto = order.getItems()
                .stream()
                .map(item -> {
                    OrderItemResponseDTO itemDto = new OrderItemResponseDTO();
                    itemDto.setId(item.getId());
                    itemDto.setQuantity(item.getQuantity());
                    itemDto.setUnitPrice(item.getUnitPrice());
                    itemDto.setSubTotal(item.getSubTotal());
                    itemDto.setProductId(item.getProductId());

                    ProductResponseDTO productDto = productService.getById(item.getProductId());
                    itemDto.setProductName(productDto.getName());
                    return itemDto;
                }).toList();

        dto.setItems(itemsDto);
        return dto;
    }

}
