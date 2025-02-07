package pe.estebancoder.solutions.shop.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pe.estebancoder.solutions.shop.validator.DateFormat;

import java.time.ZoneId;
import java.util.TimeZone;

@Data
public class UserRequestDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @DateFormat(message = "Formato de fecha incorrecta")
    private String fechaInscripcion;

    //private ZoneId timeZone;
}
