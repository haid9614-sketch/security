package com.duong.security;

import com.duong.security.Service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner testRegister(AuthService authService) {
//		return args -> {
//			System.out.println("--- TIẾN HÀNH ĐĂNG KÝ USER THỬ NGHIỆM ---");
//
//			// Thử tạo một tài khoản tên là "duongit" với mật khẩu "biemat123"
//			authService.registerUser("duongit", "biemat123");
//
//			System.out.println("--- ĐÃ LƯU XUỐNG DATABASE! KIỂM TRA MYSQL WORKBENCH NHÉ ---");
//		};
//	}


//	@Bean
//	public CommandLineRunner testHash(PasswordEncoder encoder) {
//		return args -> {
//			System.out.println("--- TEST BCRYPT ---");
//			String rawPass = "admin@123"; // Mật khẩu gốc chưa mã hóa
//
//			// Băm cùng 1 mật khẩu 2 lần
//			String hash1 = encoder.encode(rawPass);
//			String hash2 = encoder.encode(rawPass);
//
//			System.out.println("Hash 1: " + hash1);
//			System.out.println("Hash 2: " + hash2);
//			System.out.println("Giống nhau không?: " + hash1.equals(hash2));
//			System.out.println("-------------------");
//		};
//	}
}
