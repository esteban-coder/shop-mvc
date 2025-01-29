package pe.estebancoder.solutions.shop.dto;

import lombok.Data;

@Data
public class UserResponseDTO{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;

}

