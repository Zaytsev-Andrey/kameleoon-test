package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.entity.QuoteWithVoting;

import java.util.List;

public interface QuoteWithVotingService {

    QuoteWithVoting findQuoteById(Long id);

    List<QuoteWithVoting> findAllQuotes();

    List<QuoteWithVoting> findTopQuotesWithLimit(int limit);

}
