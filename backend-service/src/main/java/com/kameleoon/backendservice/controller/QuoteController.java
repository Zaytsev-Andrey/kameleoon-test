package com.kameleoon.backendservice.controller;

import com.kameleoon.backendservice.dto.QuoteDto;
import com.kameleoon.backendservice.dto.VotesPerDayDto;
import com.kameleoon.backendservice.service.QuoteService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "This method is used to get quote by id")
    @GetMapping("/{id}")
    public QuoteDto getQuoteById(@PathVariable("id") Long id) {
        return quoteService.getPersistQuote(id);
    }

    @ApiOperation(value = "This method is used to get all quote")
    @GetMapping("/all")
    public List<QuoteDto> getAllQuote() {
        return quoteService.getAllPersistQuotes();
    }

    @ApiOperation(value = "This method is used to get top 10 quote")
    @GetMapping("/top")
    public List<QuoteDto> getTopQuotes() {
        return quoteService.getTopQuotes();
    }

    @ApiOperation(value = "This method is used to get random quote")
    @GetMapping("/random")
    public QuoteDto getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @ApiOperation(value = "This method is used to get graph of the evolution quote per day")
    @GetMapping("/{id}/day/evolution")
    public List<VotesPerDayDto> getGraphOfEvolutionForQuote(@PathVariable("id") Long id) {
        return quoteService.getGraphOfEvolutionForQuote(id);
    }

    @ApiOperation(value = "This method is used to create quote")
    @PostMapping
    public QuoteDto createQuote(@Valid @RequestBody QuoteDto quoteDto, @RequestHeader("User-Id") String userId) {
        return quoteService.newQuote(quoteDto, Long.parseLong(userId));
    }

    @ApiOperation(value = "This method is used to update quote")
    @PutMapping
    public QuoteDto updateQuote(@Valid @RequestBody QuoteDto quoteDto) {
        return quoteService.updateQuote(quoteDto);
    }

    @ApiOperation(value = "This method is used to delete quote")
    @DeleteMapping("/{id}")
    public void deleteQuoteById(@PathVariable("id") Long id) {
        quoteService.deleteQuote(id);
    }

    @ApiOperation(value = "This method is used to upvote quote")
    @PatchMapping("{id}/upvote")
    public QuoteDto upvote(@PathVariable("id") Long quoteId, @RequestHeader("User-Id") String userId) {
        return quoteService.upvote(quoteId, Long.parseLong(userId));
    }

    @ApiOperation(value = "This method is used to downvote quote")
    @PatchMapping("{id}/downvote")
    public QuoteDto downvote(@PathVariable("id") Long quoteId, @RequestHeader("User-Id") String userId) {
        return quoteService.downvote(quoteId, Long.parseLong(userId));
    }
}
