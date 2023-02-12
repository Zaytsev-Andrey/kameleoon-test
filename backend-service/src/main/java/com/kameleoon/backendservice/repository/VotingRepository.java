package com.kameleoon.backendservice.repository;

import com.kameleoon.backendservice.entity.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRepository extends JpaRepository<Voting, Long> {
}
