package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.service.UserAddressService;
import org.springframework.stereotype.Service;

@Service
public class UserAddressController {

    UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }
}
