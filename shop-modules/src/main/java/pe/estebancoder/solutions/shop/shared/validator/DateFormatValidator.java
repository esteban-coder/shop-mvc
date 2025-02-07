package pe.estebancoder.solutions.shop.shared.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private String pattern;

    @Override
    public void initialize(DateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true; // Permitir valores nulos o vacíos
        }

        try {
            // Intenta parsear la fecha con el patrón proporcionado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate date = LocalDate.parse(value, formatter);

            // Verificar si la fecha parseada coincide con la fecha original
            return date.format(formatter).equals(value) && isDateValid(date);
        } catch (DateTimeParseException e) {
            return false; // La fecha no pudo ser parseada correctamente
        }
    }

    private boolean isDateValid(LocalDate date) {
        try {
            // Intenta formatear la fecha en el mismo formato para comprobar la consistencia
            date.format(DateTimeFormatter.ofPattern(pattern));
            return true;
        } catch (DateTimeException e) {
            return false; // La fecha es inválida debido a restricciones del calendario
        }
    }
}
