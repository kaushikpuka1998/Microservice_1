package com.example.kgstrivers.microservices.Services;

import com.example.kgstrivers.microservices.Models.Loginrequest;
import com.example.kgstrivers.microservices.Models.User;
import com.example.kgstrivers.microservices.Repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

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

    public User loggedIn(Loginrequest loginrequest) {

        User user = findByUserID(loginrequest.getUsername());


        String givenpassword = loginrequest.getPassword();
        String useroriginalpasshash = user.getPassword();
        if (passwordEncoder.matches(givenpassword,useroriginalpasshash))
        {
            return user;
        }
        return new User();
    }
}
