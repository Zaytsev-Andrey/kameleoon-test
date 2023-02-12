package com.kameleoon.backendservice.controller;

import com.kameleoon.backendservice.dto.QuoteDto;
import com.kameleoon.backendservice.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/{id}")
    public QuoteDto getQuoteById(@PathVariable("id") Long id) {
        return quoteService.getPersistQuote(id);
    }

    @GetMapping("/all")
    public List<QuoteDto> getAllQuote() {
        return quoteService.getAllPersistQuotes();
    }

    @GetMapping("/top")
    public List<QuoteDto> getTopQuotes() {
        return quoteService.getTopQuotes();
    }

    @GetMapping("/random")
    public QuoteDto getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @PostMapping
    public QuoteDto createQuote(@Valid @RequestBody QuoteDto quoteDto, @RequestHeader("User-Id") String userId) {
        return quoteService.newQuote(quoteDto, Long.parseLong(userId));
    }


    @PutMapping
    public QuoteDto updateQuote(@Valid @RequestBody QuoteDto quoteDto) {
        return quoteService.updateQuote(quoteDto);
    }

    @DeleteMapping("/{id}")
    public void deleteQuoteById(@PathVariable("id") Long id) {
        quoteService.deleteQuote(id);
    }

    @PatchMapping("{id}/upvote")
    public QuoteDto upvote(@PathVariable("id") Long quoteId, @RequestHeader("User-Id") String userId) {
        return quoteService.upvote(quoteId, Long.parseLong(userId));
    }

    @PatchMapping("{id}/downvote")
    public QuoteDto downvote(@PathVariable("id") Long quoteId, @RequestHeader("User-Id") String userId) {
        return quoteService.downvote(quoteId, Long.parseLong(userId));
    }
}
