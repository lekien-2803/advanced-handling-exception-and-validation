package com.myproject.advanceexceptionhandlingvalidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.advanceexceptionhandlingvalidation.dto.request.ApiResponse;
import com.myproject.advanceexceptionhandlingvalidation.dto.request.UserCreationRequest;
import com.myproject.advanceexceptionhandlingvalidation.dto.request.UserUpdateRequest;
import com.myproject.advanceexceptionhandlingvalidation.entity.User;
import com.myproject.advanceexceptionhandlingvalidation.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Create
    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        User user = userService.createUser(request);
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(user);
        return apiResponse;
    }

    // Read
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ApiResponse<User> getUserById(@PathVariable("userId") String userId) {
        User user = userService.getUserById(userId);
        ApiResponse apiResponse = new ApiResponse<>();

        apiResponse.setResult(user);

        return apiResponse;
    }
    
    // Update
    @PutMapping("/{userId}")
    public ApiResponse<User> updateUser(@PathVariable("userId") String userId, @RequestBody @Valid UserUpdateRequest request) {
        User user = userService.updateUser(userId, request);
        ApiResponse apiResponse = new ApiResponse<>();

        apiResponse.setResult(user);

        return apiResponse;
    }

    // Delete
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User has been deleted.";
    }
    
}
