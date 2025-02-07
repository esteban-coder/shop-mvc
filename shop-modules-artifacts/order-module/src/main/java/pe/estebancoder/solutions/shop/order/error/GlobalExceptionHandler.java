package pe.estebancoder.solutions.shop.order.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.estebancoder.solutions.shop.order.exception.InsufficientStockException;
import pe.estebancoder.solutions.shop.order.exception.UserNotValidException;
import pe.estebancoder.solutions.shop.shared.error.ErrorReponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotValidException.class)
    public ResponseEntity<ErrorReponse> handleException(final UserNotValidException e) {
        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setCodError(1);//101: error comunicacion / 102: error bd
        errorReponse.setMessage("Error en aplicación");
        errorReponse.setTimestamp(LocalDateTime.now());
        errorReponse.setStatus(HttpStatus.BAD_REQUEST.name());
        return new ResponseEntity<>(errorReponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorReponse> handleException(final InsufficientStockException e) {
        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setCodError(2);//101: error comunicacion / 102: error bd
        errorReponse.setMessage("Error en Almacen");
        errorReponse.setTimestamp(LocalDateTime.now());
        errorReponse.setStatus(HttpStatus.BAD_REQUEST.name());
        return new ResponseEntity<>(errorReponse, HttpStatus.BAD_REQUEST);
    }
}
