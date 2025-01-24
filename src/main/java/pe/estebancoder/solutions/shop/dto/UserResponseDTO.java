package pe.estebancoder.solutions.shop.dto;

public record UserResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Boolean active
){}

