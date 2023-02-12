package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.entity.Voting;
import com.kameleoon.backendservice.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingOperationService implements VotingService {

    private final VotingRepository votingRepository;

    @Autowired
    public VotingOperationService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    @Override
    public Voting saveVoting(Voting voting) {
        return votingRepository.save(voting);
    }
}
