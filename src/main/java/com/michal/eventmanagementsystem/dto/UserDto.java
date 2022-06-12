package com.michal.eventmanagementsystem.dto;

import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private UserAddressDto userAddress;

    private JsonNullable<String> userName;

    private JsonNullable<String> surname;

    private JsonNullable<String> login;

    private JsonNullable<String> password;

    private JsonNullable<String> email;


    public boolean hasUserName() {
        return userName != null && userName.isPresent();
    }

    public boolean hasSurname() {
        return surname != null && surname.isPresent();
    }

    public boolean hasLogin() {
        return login != null && login.isPresent();
    }

    public boolean hasPassword() {
        return password != null && password.isPresent();
    }

    public boolean hasEmail() {
        return email != null && email.isPresent();
    }
}
