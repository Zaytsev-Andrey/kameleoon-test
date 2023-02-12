package com.kameleoon.backendservice.repository;

import com.kameleoon.backendservice.entity.QuoteWithVoting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteWithVotingRepository extends JpaRepository<QuoteWithVoting, Long> {
}
