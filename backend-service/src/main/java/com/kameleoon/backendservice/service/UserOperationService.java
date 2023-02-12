package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.UserDto;
import com.kameleoon.backendservice.entity.User;
import com.kameleoon.backendservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOperationService implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    @Autowired
    public UserOperationService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User getPersistUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("User with id='" + id + "' not found"));
    }

    @Override
    public UserDto newUser(UserDto userDto) {
        User savedUser = userRepository.save(mapper.map(userDto, User.class));
        return mapper.map(savedUser, UserDto.class);
    }
}
