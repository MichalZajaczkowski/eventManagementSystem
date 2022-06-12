package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.UserDto;
import com.michal.eventmanagementsystem.mapper.UserManager;
import com.michal.eventmanagementsystem.model.User;
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

    public void save(User user) {
        if (user.getUserAddress() != null && user.getUserAddress().getId() != null) {
            Long id = user.getUserAddress().getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                user.setUserAddress(userAddress);
                                userRepository.save(user);
                            }
                    );
        } else {
            userRepository.save(user);
        }
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

    public void update(User user) {
        if (user.getUserAddress() == null && user.getUserAddress().getId() == null) {
            Long id = user.getUserAddress().getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                user.setUserAddress(userAddress);
                                userRepository.save(user);
                            }
                    );
        } else {
            userRepository.save(user);
        }
    }
}