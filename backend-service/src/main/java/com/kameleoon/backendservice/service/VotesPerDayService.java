package com.kameleoon.backendservice.service;

import com.kameleoon.backendservice.entity.VotesPerDay;

import java.util.List;

public interface VotesPerDayService {

    List<VotesPerDay> getGraphOfEvolutionForQuote(Long id);
}
