package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.mapper.UserManager;
import com.michal.eventmanagementsystem.model.User;
import com.michal.eventmanagementsystem.repository.UserAddressRepository;
import com.michal.eventmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

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
}
