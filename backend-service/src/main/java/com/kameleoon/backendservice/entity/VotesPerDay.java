package com.kameleoon.backendservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@org.hibernate.annotations.Subselect(
        value = "select row_number() over() id, iv.quote_id, iv.creation_date, iv.votes " +
                "from quote q " +
                "left join (select v.quote_id, v.creation_date, sum(v.vote) votes " +
                        "from voting v " +
                        "group by v.quote_id, v.creation_date) iv on q.id = iv.quote_id"
)
@org.hibernate.annotations.Synchronize({"voting"})
public class VotesPerDay {

    @Id
    protected Long id;

    @Column(name = "quote_id")
    protected long quoteId;

    @Column(name = "creation_date")
    protected Date creationDate;

    protected long votes;

    public VotesPerDay() {
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getVotes() {
        return votes;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotesPerDay that = (VotesPerDay) o;
        return Objects.equals(quoteId, that.quoteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteId);
    }

    @Override
    public String toString() {
        return "VotesPerDay{" +
                "votingDay=" + creationDate +
                ", votes=" + votes +
                '}';
    }
}
