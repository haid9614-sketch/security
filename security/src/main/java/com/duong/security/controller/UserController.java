package com.duong.security.controller;
import com.duong.security.requestDTO.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/users")
public class UserController {
    // http://localhost:8080/api/users/regist
    @PostMapping("/regist")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errors = bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errors);
        }
        System.out.println("da tao tai khoan co email: " + newUser.getEmail() + " thanh conh !!!");
        return ResponseEntity.ok("tao user thanh cong");
    }
}