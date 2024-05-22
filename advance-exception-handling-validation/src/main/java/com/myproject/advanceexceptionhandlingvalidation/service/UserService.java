package com.myproject.advanceexceptionhandlingvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.advanceexceptionhandlingvalidation.dto.request.UserCreationRequest;
import com.myproject.advanceexceptionhandlingvalidation.dto.request.UserUpdateRequest;
import com.myproject.advanceexceptionhandlingvalidation.entity.User;
import com.myproject.advanceexceptionhandlingvalidation.exception.AppException;
import com.myproject.advanceexceptionhandlingvalidation.exception.ErrorCode;
import com.myproject.advanceexceptionhandlingvalidation.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        if (userRepository.existsByEmail(request.getUsername())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        User user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(request.getPassword())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .dob(request.getDob())
            .build();
        
            return userRepository.save(user);
    }

    // Read
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }

    // Update
    public User updateUser(String id, UserUpdateRequest request) {
        User updateUser = getUserById(id);

        updateUser.setPassword(request.getPassword());
        updateUser.setFirstName(request.getFirstName());
        updateUser.setLastName(request.getLastName());
        updateUser.setDob(request.getDob());

        return userRepository.save(updateUser);
    }

    // Delete
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
