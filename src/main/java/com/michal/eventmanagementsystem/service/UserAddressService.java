package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.mapper.UserAddressMapper;
import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    UserAddressMapper userAddressServiceMapper;
    UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressMapper userAddressServiceMapper, UserAddressRepository userAddressRepository) {
        this.userAddressServiceMapper = userAddressServiceMapper;
        this.userAddressRepository = userAddressRepository;
    }

    public void save(UserAddress userAddress) {
        if (userAddress.getId() != null) {
            Long id = userAddress.getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress1 -> {
                                userAddress.setId(userAddress1.getId());
                                userAddressRepository.save(userAddress);
                            }
                    );
        } else {
            userAddressRepository.save(userAddress);
        }
    }
}
