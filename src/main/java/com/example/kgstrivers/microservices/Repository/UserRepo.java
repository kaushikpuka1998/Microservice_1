package com.example.kgstrivers.microservices.Repository;

import com.example.kgstrivers.microservices.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
