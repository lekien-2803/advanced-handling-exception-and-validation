package com.myproject.advanceexceptionhandlingvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.advanceexceptionhandlingvalidation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{ 
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
