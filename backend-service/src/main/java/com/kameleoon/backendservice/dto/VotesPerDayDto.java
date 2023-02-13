package com.kameleoon.backendservice.dto;

import java.util.Date;
import java.util.Objects;

public class VotesPerDayDto {

    private Date creationDate;

    private long votes;

    public VotesPerDayDto() {
    }

    public VotesPerDayDto(Date creationDate, long votes) {
        this.creationDate = creationDate;
        this.votes = votes;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotesPerDayDto that = (VotesPerDayDto) o;
        return votes == that.votes && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, votes);
    }

    @Override
    public String toString() {
        return "VotesPerDayDto{" +
                "votingDay=" + creationDate +
                ", votes=" + votes +
                '}';
    }
}
