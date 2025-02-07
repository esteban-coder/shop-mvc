package pe.estebancoder.solutions.shop.modules.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.shop.modules.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
