package com.kameleoon.backendservice.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "voting", indexes = {
        @Index(name = "unique_user_quote", columnList = "user_id, quote_id", unique = true)
})
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected byte vote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id", nullable = false)
    protected Quote quote;

    public Voting() {
    }

    public Voting(byte vote, User user, Quote quote) {
        this.vote = vote;
        this.user = user;
        this.quote = quote;
    }

    public Voting(Long id, byte vote, User user, Quote quote) {
        this.id = id;
        this.vote = vote;
        this.user = user;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public byte isVote() {
        return vote;
    }

    public User getUser() {
        return user;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setVote(byte vote) {
        this.vote = vote;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voting voting = (Voting) o;
        return Objects.equals(id, voting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Voting{" +
                "id=" + id +
                ", vote=" + vote +
                ", user=" + user +
                ", quote=" + quote +
                '}';
    }
}


