package pe.estebancoder.solutions.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.estebancoder.solutions.shop.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
