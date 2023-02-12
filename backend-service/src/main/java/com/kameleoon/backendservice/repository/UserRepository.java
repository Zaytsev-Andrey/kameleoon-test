package com.kameleoon.backendservice.repository;


import com.kameleoon.backendservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
