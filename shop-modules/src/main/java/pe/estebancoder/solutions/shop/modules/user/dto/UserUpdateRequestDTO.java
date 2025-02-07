package pe.estebancoder.solutions.shop.modules.user.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
}
