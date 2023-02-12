package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.dto.QuoteDto;
import com.kameleoon.backendservice.entity.Quote;
import com.kameleoon.backendservice.entity.Voting;
import com.kameleoon.backendservice.repository.QuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteOperationService implements QuoteService {

    private static final byte UPVOTE_VALUE = 1;

    private static final byte DOWNVOTE_VALUE = -1;

    private static final int TOP_QUOTES_LIMIT = 10;

    private final QuoteRepository quoteRepository;

    private final UserService userService;

    private final QuoteWithVotingService quoteWithVotingService;

    private final VotingService votingService;

    private final ModelMapper mapper;

    @Autowired
    public QuoteOperationService(QuoteRepository quoteRepository, UserService userService,
                                 QuoteWithVotingService quoteWithVotingService,
                                 VotingService votingService, ModelMapper mapper) {
        this.quoteRepository = quoteRepository;
        this.userService = userService;
        this.quoteWithVotingService = quoteWithVotingService;
        this.votingService = votingService;
        this.mapper = mapper;
    }

    @Override
    public QuoteDto getPersistQuote(Long id) {
        return mapper.map(quoteWithVotingService.findQuoteById(id), QuoteDto.class);
    }

    @Override
    public List<QuoteDto> getAllPersistQuotes() {
        return quoteWithVotingService.findAllQuotes().stream()
                .map(q -> mapper.map(q, QuoteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<QuoteDto> getTopQuotes() {
        return quoteWithVotingService.findTopQuotesWithLimit(TOP_QUOTES_LIMIT).stream()
                .map(q -> mapper.map(q, QuoteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QuoteDto getRandomQuote() {
        long randomId = quoteRepository.findRandomIdQuote();
        return getPersistQuote(randomId);
    }

    @Override
    public QuoteDto newQuote(QuoteDto quoteDto, Long userId) {
        Quote quote = mapper.map(quoteDto, Quote.class);
        quote.setUser(userService.getPersistUser(userId));
        Quote savedQuote = quoteRepository.save(quote);
        return getPersistQuote(savedQuote.getId());
    }

    @Override
    public QuoteDto updateQuote(QuoteDto quoteDto) {
        Quote quote = quoteRepository.findById(quoteDto.getId())
                .orElseThrow(() -> new NullPointerException(String.format("Quote with id='%d' notfound", quoteDto.getId())));
        quote.setContent(quoteDto.getContent());
        quoteRepository.save(quote);
        return getPersistQuote(quote.getId());
    }

    @Override
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public QuoteDto upvote(Long quoteId, Long userId) {
        vote(quoteId, userId, UPVOTE_VALUE);
        return getPersistQuote(quoteId);
    }

    @Override
    public QuoteDto downvote(Long quoteId, Long userId) {
        vote(quoteId, userId, DOWNVOTE_VALUE);
        return getPersistQuote(quoteId);
    }

    protected void vote(Long quoteId, Long userId, byte voteValue) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new NullPointerException(String.format("Quote with id='%d' notfound", quoteId)));
        Voting voting = new Voting(voteValue, userService.getPersistUser(userId), quote);
        votingService.saveVoting(voting);
    }
}
