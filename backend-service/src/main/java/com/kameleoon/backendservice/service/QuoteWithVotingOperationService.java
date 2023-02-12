package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.entity.QuoteWithVoting;
import com.kameleoon.backendservice.repository.QuoteWithVotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteWithVotingOperationService implements QuoteWithVotingService {

    private final QuoteWithVotingRepository quoteWithVotingRepository;

    @Autowired
    public QuoteWithVotingOperationService(QuoteWithVotingRepository quoteWithVotingRepository) {
        this.quoteWithVotingRepository = quoteWithVotingRepository;
    }

    @Override
    public QuoteWithVoting findQuoteById(Long id) {
        return quoteWithVotingRepository.findById(id)
                .orElseThrow(() -> new NullPointerException(String.format("Quote with id='%d' notfound", id)));
    }

    @Override
    public List<QuoteWithVoting> findAllQuotes() {
        return quoteWithVotingRepository.findAll();
    }

    @Override
    public List<QuoteWithVoting> findTopQuotesWithLimit(int limit) {
        return quoteWithVotingRepository.findAll(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "votes")))
                .getContent();
    }

}
