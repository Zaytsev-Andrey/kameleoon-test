package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.QuoteDto;

import java.util.List;

public interface QuoteService {

    QuoteDto getPersistQuote(Long id);

    List<QuoteDto> getAllPersistQuotes();

    List<QuoteDto> getTopQuotes();

    QuoteDto getRandomQuote();

    QuoteDto newQuote(QuoteDto quoteDto, Long userId);

    QuoteDto updateQuote(QuoteDto quoteDto);

    void deleteQuote(Long id);

    QuoteDto upvote(Long quoteId, Long userId);

    QuoteDto downvote(Long quoteId, Long userId);

}
