package com.duong.security.Service;

import com.duong.security.Entity.Users;
import com.duong.security.config.SecurityConfig;
import com.duong.security.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users registerUser(String userName, String rawPassword) {

        String hashedPass = passwordEncoder.encode(rawPassword);
        Users newUser = new Users();
        newUser.setUserName(userName);
        newUser.setPassword(hashedPass);
        newUser.setRole("USER");

        return usersRepository.save(newUser);
    }
}
