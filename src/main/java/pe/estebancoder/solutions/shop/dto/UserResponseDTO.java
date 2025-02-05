package pe.estebancoder.solutions.shop.dto;

import lombok.Data;
import org.hibernate.boot.model.process.internal.UserTypeResolution;

@Data
public class UserResponseDTO{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;

}



//public record UserResponseDTO(
//         Long id,
//         String firstName,
//         String lastName,
//         String email,
//         Boolean active
//)
//{
//    // methods
//}
