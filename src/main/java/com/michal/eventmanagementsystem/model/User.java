package com.michal.eventmanagementsystem.model;

import lombok.Data;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
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


    public void setUserName2(JsonNullable<String> userName) {
        this.userName = userName.orElse(null);
    }

        public void setSurname2(JsonNullable<String> surname2) {
        this.surname = surname2.orElse(null);
    }

    public void setEmail2(JsonNullable<String> email) {
        this.email = email.orElse(null);
    }

    public void setLogin2(JsonNullable<String> login) {
        this.login = login.orElse(null);
    }

    public void setPassword2(JsonNullable<String> password) {
        this.password = password.orElse(null);

    }
}
