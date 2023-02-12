package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.UserDto;
import com.kameleoon.backendservice.entity.User;

public interface UserService {

    User getPersistUser(Long id);

    UserDto newUser(UserDto userDto);
}
