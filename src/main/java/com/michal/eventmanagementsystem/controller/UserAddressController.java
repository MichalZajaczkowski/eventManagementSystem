package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.UserAddressDto;
import com.michal.eventmanagementsystem.model.UserAddress;
import com.michal.eventmanagementsystem.service.UserAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping()
    public List<UserAddress> findAll() {
        return userAddressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserAddress> findById(@PathVariable Long id) {
        return userAddressService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<UserAddressDto> save(@RequestBody UserAddressDto userAddressDto) {
        userAddressService.save(userAddressDto);
        return new ResponseEntity<>(userAddressDto, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UserAddressDto> update(@RequestBody UserAddressDto userAddressDto) {
        userAddressService.update(userAddressDto);
        return new ResponseEntity<>(userAddressDto, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<UserAddressDto> partialUpdate(@RequestBody UserAddressDto userAddressDto) {
        userAddressService.partialUpdate(userAddressDto);
        return new ResponseEntity<>(userAddressDto, HttpStatus.OK);
    }
}
