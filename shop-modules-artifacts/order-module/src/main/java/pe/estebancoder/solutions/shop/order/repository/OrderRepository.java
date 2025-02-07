package pe.estebancoder.solutions.shop.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.shop.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
