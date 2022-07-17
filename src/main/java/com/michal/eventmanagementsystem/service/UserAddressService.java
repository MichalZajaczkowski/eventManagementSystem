package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.UserAddressDto;
import com.michal.eventmanagementsystem.mapper.UserAddressMapper;
import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService {

    UserAddressMapper userAddressServiceMapper;
    UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressMapper userAddressServiceMapper, UserAddressRepository userAddressRepository) {
        this.userAddressServiceMapper = userAddressServiceMapper;
        this.userAddressRepository = userAddressRepository;
    }

    public List<UserAddress> findAll() {
        return userAddressRepository.findAll();
    }

    public Optional<UserAddress> findById(Long id) {
        return userAddressRepository.findById(id);
    }

    public void save(UserAddressDto userAddressDto) {
        if (userAddressDto.getId() != null) {
            Long id = userAddressDto.getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                userAddressDto.setId(userAddress.getId());
                                userAddressRepository.save(userAddressDto.toUserAddress());
                            }
                    );
        } else {
            userAddressRepository.save(userAddressDto.toUserAddress());
        }
    }

    public void update(UserAddressDto userAddressDto) {
        if (userAddressDto.getId() != null) {
            Long id = userAddressDto.getId();
            userAddressRepository.findById(id)
                    .ifPresent(userAddress -> {
                                userAddressDto.setId(id);
                                userAddressRepository.save(userAddressDto.toUserAddress());
                            }
                    );
        }
    }


    public void partialUpdate(UserAddressDto userAddressDto) {
        UserAddress userAddress = userAddressRepository.findById(userAddressDto.getId()).orElse(null);
        if (userAddress != null) {
            if (userAddressDto.getCountry() != null) {
                userAddress.setCountry(userAddressDto.getCountry().orElse(userAddress.getCountry()));
            }
            if (userAddressDto.getCity() != null) {
                userAddress.setCity(userAddressDto.getCity().orElse(userAddress.getCity()));
            }
            if (userAddressDto.getStreetName() != null) {
                userAddress.setStreetName(userAddressDto.getStreetName().orElse(userAddress.getStreetName()));
            }
            if (userAddressDto.getStreetNumber() != null) {
                userAddress.setStreetNumber(userAddressDto.getStreetNumber().orElse(userAddress.getStreetNumber()));
            }
            if (userAddressDto.getZipCode() != null) {
                userAddress.setZipCode(userAddressDto.getZipCode().orElse(userAddress.getZipCode()));
            }
            if (userAddressDto.getPhone() != null) {
                userAddress.setPhone(userAddressDto.getPhone().orElse(userAddress.getPhone()));
            }
            userAddressRepository.save(userAddress);
        }
    }
}
