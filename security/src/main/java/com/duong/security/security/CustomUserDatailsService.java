package com.duong.security.security;

import com.duong.security.Entity.Users;
import com.duong.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDatailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
     @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
         Users user = usersRepository.findByUserName(name);

         if(user == null) {
             throw new UsernameNotFoundException("Khong tim thay email: " + name);
         }
         return User.builder()
                 .username(user.getUserName())
                 .password(user.getPassword())
                 .roles("USER")
                 .build();
     }
}
