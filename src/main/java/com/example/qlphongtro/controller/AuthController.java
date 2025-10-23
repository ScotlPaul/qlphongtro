package com.example.qlphongtro.controller;

import com.example.qlphongtro.model.User;
import com.example.qlphongtro.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 👉 Hiển thị trang đăng nhập
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // 👉 Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // 👉 Xử lý nút Đăng ký
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "register";
        }

        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);

        model.addAttribute("success", "Đăng ký thành công! Hãy đăng nhập.");
        return "login"; // Sau khi đăng ký thì chuyển về trang đăng nhập
    }
}
