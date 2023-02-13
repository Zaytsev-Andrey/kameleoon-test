package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.QuoteDto;
import com.kameleoon.backendservice.dto.VotesPerDayDto;

import java.util.List;

public interface QuoteService {

    QuoteDto getPersistQuote(Long id);

    List<QuoteDto> getAllPersistQuotes();

    List<QuoteDto> getTopQuotes();

    QuoteDto getRandomQuote();

    List<VotesPerDayDto> getGraphOfEvolutionForQuote(Long id);

    QuoteDto newQuote(QuoteDto quoteDto, Long userId);

    QuoteDto updateQuote(QuoteDto quoteDto);

    void deleteQuote(Long id);

    QuoteDto upvote(Long quoteId, Long userId);

    QuoteDto downvote(Long quoteId, Long userId);

}
