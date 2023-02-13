package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.entity.VotesPerDay;
import com.kameleoon.backendservice.repository.VotesPerDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotesPerDayOperationService implements VotesPerDayService {

    private final VotesPerDayRepository votesPerDayRepository;

    @Autowired
    public VotesPerDayOperationService(VotesPerDayRepository votesPerDayRepository) {
        this.votesPerDayRepository = votesPerDayRepository;
    }

    @Override
    public List<VotesPerDay> getGraphOfEvolutionForQuote(Long id) {
        return votesPerDayRepository.findAllByQuoteIdOrderByCreationDate(id);
    }
}
