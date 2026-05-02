package com.nexuscore.userservice.service;

import com.nexuscore.userservice.dto.UserRequestDTO;
import com.nexuscore.userservice.dto.UserResponseDTO;
import com.nexuscore.userservice.entity.User;
import com.nexuscore.userservice.exception.UserNotFoundException;
import com.nexuscore.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO request) {

        log.info("Creating user with email: {}", request.getEmail());
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    public UserResponseDTO getUser(Long id) {
        log.info("Fetching user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("User not found with id: {}", id);
                     return new UserNotFoundException("User not found with id: " + id);
                });

        return mapToResponse(user);
    }

    public Page<UserResponseDTO> getAllUsers(int page, int size) {

        Page<User> users = userRepository.findAll(PageRequest.of(page, size));

        return users.map(this::mapToResponse);
    }

    private UserResponseDTO mapToResponse(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }


}