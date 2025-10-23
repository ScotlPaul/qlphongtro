package com.example.qlphongtro.service;

import com.example.qlphongtro.model.User;
import com.example.qlphongtro.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User save(User u) {
        return repo.save(u);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public long countUsers() {
        return userRepository.count();
    }
}
