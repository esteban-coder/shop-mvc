package pe.estebancoder.solutions.shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name="active", nullable = false)
    private Boolean isActive = true;


}
