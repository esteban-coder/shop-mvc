package pe.estebancoder.solutions.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.Order;

@Data
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    private Integer quantity;

    @Column(nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Double subTotal;

}
