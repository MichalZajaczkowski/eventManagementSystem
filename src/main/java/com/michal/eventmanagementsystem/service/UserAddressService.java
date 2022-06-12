package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.mapper.UserAddressMapper;
import com.michal.eventmanagementsystem.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    UserAddressMapper userAddressServiceMapper;
    UserAddressRepository userAddressRepository;

}
