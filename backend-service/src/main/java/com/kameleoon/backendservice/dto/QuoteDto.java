package com.kameleoon.backendservice.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class QuoteDto {

    private Long id;

    @NotBlank(message = "Content is required")
    private String content;

    private Date lastModified;

    private long votes;

    public QuoteDto() {
    }

    public QuoteDto(Long id, String content, Date lastModified, long voting) {
        this.id = id;
        this.content = content;
        this.lastModified = lastModified;
        this.votes = voting;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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
        QuoteDto quoteDto = (QuoteDto) o;
        return votes == quoteDto.votes && Objects.equals(id, quoteDto.id) && Objects.equals(content, quoteDto.content) && Objects.equals(lastModified, quoteDto.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, lastModified, votes);
    }

    @Override
    public String toString() {
        return "QuoteDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", lastModified=" + lastModified +
                ", voting=" + votes +
                '}';
    }
}
