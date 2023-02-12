package com.kameleoon.backendservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class UserDto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid E-mail")
    private String email;

    @NotBlank(message = "Name is required")
    private String password;

    private Date creationDate;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String password, Date creationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name)
                && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password)
                && Objects.equals(creationDate, userDto.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, creationDate);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
