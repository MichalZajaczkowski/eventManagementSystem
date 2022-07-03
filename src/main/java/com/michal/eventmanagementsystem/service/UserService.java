package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.UserDto;
import com.michal.eventmanagementsystem.mapper.UserManager;
import com.michal.eventmanagementsystem.model.User;
import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.repository.UserAddressRepository;
import com.michal.eventmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserManager userManager;
    UserRepository userRepository;
    UserAddressRepository userAddressRepository;

    public UserService(UserManager userManager, UserRepository userRepository, UserAddressRepository userAddressRepository) {
        this.userManager = userManager;
        this.userRepository = userRepository;
        this.userAddressRepository = userAddressRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return userRepository.findById(id);
        }
    }

    public void save(UserDto userDto) {
        if (userDto.getUserAddress() != null && userDto.getUserAddress().getId() != null) {
            Long id = userDto.getUserAddress().getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                userDto.setUserAddressToDto(userAddress);
                                userRepository.save(userDto.toUser());
                            }
                    );
        } else {
            userRepository.save(userDto.toUser());
        }
    }

    public void update(UserDto userDto) {
        if (userDto.getUserAddress() == null && userDto.getUserAddress().getId() == null) {
            Long id = userDto.getUserAddress().getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                userDto.getUserAddress().setId(id);
                                userRepository.save(userDto.toUser());
                            }
                    );
        } else {
            userRepository.save(userDto.toUser());
        }
    }

    public void partialUpdate(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user != null) {
            if (userDto.getUserName() != null) {
                user.setUserNameToDto(userDto.getUserName());
            }
            if (userDto.getSurname() != null) {
                user.setSurnameToDto(userDto.getSurname());
            }
            if (userDto.getEmail() != null) {
                user.setEmailToDto(userDto.getEmail());
            }
            if (userDto.getLogin() != null) {
                user.setLoginToDto(userDto.getLogin());
            }
            if (userDto.getPassword() != null) {
                user.setPasswordToDto(userDto.getPassword());
            }
            if (userDto.getUserAddress() != null || userDto.getUserAddress().getId() != null) {
                UserAddress userAddress = userAddressRepository.findById(userDto.getUserAddress().getId()).orElse(null);
                if (userAddress != null) {
                    user.setUserAddress(userAddress);
                }
            }
            userRepository.save(user);
        }
    }
}