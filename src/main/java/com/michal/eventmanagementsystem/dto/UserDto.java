package com.michal.eventmanagementsystem.dto;

import com.michal.eventmanagementsystem.model.User;
import com.michal.eventmanagementsystem.model.UserAddress;
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

    public  UserDto(User user) {
        this.id = user.getId();
        this.userAddress = new UserAddressDto(user.getUserAddress());
        this.userName = user.getUserNameToDto();
        this.surname = user.getSurnameToDto();
        this.login = user.getLoginToDto();
        this.password = user.getPasswordToDto();
        this.email = user.getEmailToDto();
    }


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

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUserName(userName.orElse(null));
        user.setSurname(surname.orElse(null));
        user.setLogin(login.orElse(null));
        user.setPassword(password.orElse(null));
        user.setEmail(email.orElse(null));
        if (userAddress != null) {
            user.setUserAddress(userAddress.toUserAddress());
        }
        return user;
    }

    public void setUserAddressToDto(UserAddress userAddress) {
        this.userAddress = new UserAddressDto(userAddress);
    }
}
