package com.michal.eventmanagementsystem.model;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;


    public void setUserNameToDto(JsonNullable<String> userName) {
        this.userName = userName.orElse(null);
    }

    public void setSurnameToDto(JsonNullable<String> surname) {
        this.surname = surname.orElse(null);
    }

    public void setEmailToDto(JsonNullable<String> email) {
        this.email = email.orElse(null);
    }

    public void setLoginToDto(JsonNullable<String> login) {
        this.login = login.orElse(null);
    }

    public void setPasswordToDto(JsonNullable<String> password) {
        this.password = password.orElse(null);

    }

    public JsonNullable<String> getUserNameToDto() {
        return userName == null ? null : JsonNullable.of(userName);
    }

    public JsonNullable<String> getSurnameToDto() {
        return surname == null ? null : JsonNullable.of(surname);
    }

    public JsonNullable<String> getEmailToDto() {
        return email == null ? null : JsonNullable.of(email);
    }

    public JsonNullable<String> getLoginToDto() {
        return login == null ? null : JsonNullable.of(login);
    }

    public JsonNullable<String> getPasswordToDto() {
        return password == null ? null : JsonNullable.of(password);
    }
}
