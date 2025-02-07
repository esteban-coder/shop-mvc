package pe.estebancoder.solutions.shop.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
@Documented
public @interface DateFormat {
    String message() default "La fecha no es válida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String pattern() default "yyyy-MM-dd"; // Formato predeterminado
}
