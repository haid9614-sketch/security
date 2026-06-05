package com.duong.security.controller;
import com.duong.security.Entity.Users;
import com.duong.security.repository.UsersRepository;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private JwtUtils jwtutils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {

        System.out.println("Tài khoản từ Postman gửi lên: " + loginRequest.getUserName());
        System.out.println("Mật khẩu từ Postman gửi lên: " + loginRequest.getPassword());

        try{
            Authentication authentication = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(
                          loginRequest.getUserName(),
                          loginRequest.getPassword()
                  )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtutils.generateTokenByUserName(loginRequest.getUserName());
            return ResponseEntity.ok(new JwtResponse(jwt, loginRequest.getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi là: " + e.getMessage());
            return ResponseEntity.badRequest().body("Đăng nhập thất bại: Sai tài khoản hoặc mật khẩu!");
        }
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto newUser) {
          String hashPass = passwordEncoder.encode(newUser.getPassword());
          Users user = new Users();
          user.setUserName(newUser.getName());
          user.setEmail(newUser.getEmail());
          user.setPassword(hashPass);
           usersRepository.save(user);
           return "Dang ki thanh cong";
    }

}
