package pe.estebancoder.solutions.shop.shared.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomResponseDTO<T> {

    private T data;
    private LocalDateTime timestamp;
    private String status;
    private String uri;
}
