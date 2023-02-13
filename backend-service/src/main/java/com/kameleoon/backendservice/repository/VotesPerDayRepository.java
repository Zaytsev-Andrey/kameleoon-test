package com.kameleoon.backendservice.repository;

import com.kameleoon.backendservice.entity.VotesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VotesPerDayRepository extends JpaRepository<VotesPerDay, Long> {

    List<VotesPerDay> findAllByQuoteIdOrderByCreationDate(Long id);
}
