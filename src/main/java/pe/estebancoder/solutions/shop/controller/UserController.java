package pe.estebancoder.solutions.shop.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.estebancoder.solutions.shop.dto.UserRequestDTO;
import pe.estebancoder.solutions.shop.dto.UserResponseDTO;
import pe.estebancoder.solutions.shop.dto.UserUpdateRequestDTO;
import pe.estebancoder.solutions.shop.service.UserService;
import pe.estebancoder.solutions.shop.service.impl.UserServiceImpl;

import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request){
        UserResponseDTO userDTO = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequestDTO request){
        return ResponseEntity.ok(userService.update(id, request));
    }


}
