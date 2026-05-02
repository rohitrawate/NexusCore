package com.nexuscore.userservice.controller;

import com.nexuscore.userservice.dto.ApiResponse;
import com.nexuscore.userservice.dto.UserRequestDTO;
import com.nexuscore.userservice.dto.UserResponseDTO;
import com.nexuscore.userservice.entity.User;
import com.nexuscore.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping
//    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO request) {
//        return userService.createUser(request);
//    }
    @PostMapping
    public ApiResponse<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        return new ApiResponse<>(true, "User created successfully",
                userService.createUser(request));
    }

//    @GetMapping("/{id}")
//    public UserResponseDTO getUser(@PathVariable Long id) {
//        return userService.getUser(id);
//    }
    @GetMapping("/{id}")
    public ApiResponse<UserResponseDTO> getUser(@PathVariable Long id) {
        return new ApiResponse<>(true, "User fetched successfully",
                userService.getUser(id));
    }

    @GetMapping
    public Page<UserResponseDTO> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return userService.getAllUsers(page, size);
    }
}