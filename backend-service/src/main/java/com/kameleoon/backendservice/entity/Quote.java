package com.kameleoon.backendservice.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false, length = 4096)
    protected String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    @org.hibernate.annotations.UpdateTimestamp
    protected Date lastModified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    @OneToMany(mappedBy = "quote", orphanRemoval = true)
    protected Set<Voting> votingSet = new HashSet<>();

    public Quote() {
    }

    public Quote(Long id, String content, Date lastModified, User user, Set<Voting> votingSet) {
        this.id = id;
        this.content = content;
        this.lastModified = lastModified;
        this.user = user;
        this.votingSet = votingSet;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public User getUser() {
        return user;
    }

    public Set<Voting> getVotingSet() {
        return votingSet;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(id, quote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", lastModified=" + lastModified +
                ", user=" + user +
                ", voting=" + votingSet +
                '}';
    }
}
