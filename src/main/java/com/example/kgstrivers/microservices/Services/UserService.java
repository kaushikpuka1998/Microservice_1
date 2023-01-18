package com.example.kgstrivers.microservices.Services;

import com.example.kgstrivers.microservices.Models.User;
import com.example.kgstrivers.microservices.Repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepo userRepo;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user)
    {
        String encodepassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodepassword);
        return this.userRepo.save(user);
    }

    public User findByUserID(String username)
    {
        return this.userRepo.findByUsername(username);
    }
}
