package com.kameleoon.backendservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quote_with_voting")
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
        value = "select q.id, q.content, q.last_modified, ifnull(v_v.votes, 0) votes " +
                "from quote q " +
                "left join (" +
                "   select v.quote_id quoteId, SUM(v.vote) votes from voting v group by v.quote_id" +
                ") v_v on q.id = v_v.quoteId"
)
@org.hibernate.annotations.Synchronize({"quote, voting"})
public class QuoteWithVoting {

    @Id
    protected Long id;

    protected String content;

    @Column(name = "last_modified")
    protected Date lastModified;

    protected Long votes;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public long getVotes() {
        return votes;
    }
}
