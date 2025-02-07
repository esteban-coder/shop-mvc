package pe.estebancoder.solutions.shop.shared.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorReponse {
    private Integer codError;
    private String message;
    private String status;
    private LocalDateTime timestamp;
}
