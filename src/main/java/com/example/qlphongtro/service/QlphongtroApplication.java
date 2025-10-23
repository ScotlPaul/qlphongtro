package com.example.qlphongtro.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.qlphongtro.model.User;
import com.example.qlphongtro.repository.UserRepository;

@SpringBootApplication
public class QlphongtroApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlphongtroApplication.class, args);
    }

    // ✅ Tạo tài khoản mặc định admin/12345 khi khởi động lần đầu
    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("12345"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Đã tạo tài khoản mặc định: admin / 12345 (ADMIN)");
            } else {
                System.out.println("ℹ️ Database đã có tài khoản, bỏ qua tạo mặc định.");
            }
        };
    }
}
