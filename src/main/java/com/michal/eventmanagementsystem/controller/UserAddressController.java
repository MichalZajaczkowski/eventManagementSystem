package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.service.UserAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserAddress userAddress) {
        userAddressService.save(userAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body("UserAddress with id: " + userAddress.getId() + " was created");
    }
}
