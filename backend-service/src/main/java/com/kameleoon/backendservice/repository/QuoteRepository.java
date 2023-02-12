package com.kameleoon.backendservice.repository;

import com.kameleoon.backendservice.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(nativeQuery = true, value = "select q.id from quote q order by rand() limit 1")
    Long findRandomIdQuote();
}
