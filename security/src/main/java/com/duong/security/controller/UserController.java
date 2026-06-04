package com.duong.security.controller;
import com.duong.security.requestDTO.LoginRequest;
import com.duong.security.requestDTO.UserDto;
import com.duong.security.responseDTO.JwtResponse;
import com.duong.security.security.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private JwtUtils jwtutils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(
                          loginRequest.getUsernName(),
                          loginRequest.getPassword()
                  )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtutils.generateTokenByUserName(loginRequest.getUsernName());
            return ResponseEntity.ok(new JwtResponse(jwt, loginRequest.getUsernName()));
        } catch (Exception e) {
              return ResponseEntity.badRequest().body("Dang nhap that bai, sai email hoac mat khau");
        }
    }
}
