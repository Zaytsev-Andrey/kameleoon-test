package com.kameleoon.backendservice.config;

import com.kameleoon.backendservice.dto.UserDto;
import com.kameleoon.backendservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(m -> m.skip(User::getPassword, UserDto::setPassword));

        return mapper;
    }
}
