package pe.estebancoder.solutions.shop.dto;

public record ProductResponseDTO (
        Long id,
        String name,
        String description,
        Double price,
        Integer stockQuantity,
        Boolean active
)
{
}
