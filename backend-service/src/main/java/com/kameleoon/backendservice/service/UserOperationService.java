package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.UserDto;
import com.kameleoon.backendservice.entity.User;
import com.kameleoon.backendservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserOperationService implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserOperationService(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getPersistUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("User with id='" + id + "' not found"));
    }

    @Override
    public UserDto newUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(mapper.map(userDto, User.class));
        return mapper.map(savedUser, UserDto.class);
    }
}
