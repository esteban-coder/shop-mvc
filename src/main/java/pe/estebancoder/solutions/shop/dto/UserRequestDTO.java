package pe.estebancoder.solutions.shop.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRequestDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
