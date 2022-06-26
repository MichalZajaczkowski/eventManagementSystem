package com.michal.eventmanagementsystem.controller;

import com.michal.eventmanagementsystem.dto.UserDto;
import com.michal.eventmanagementsystem.model.User;
import com.michal.eventmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(value -> ResponseEntity.status(HttpStatus.OK).body("User with id: " + user.get().getId() + " was found"))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id: " + id + " was not found"));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@Valid @RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).body("User with id: " + user.getId() + " was updated");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> partialUpdate(@RequestBody UserDto userDto) {
        userService.partialUpdate(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("User with id: " + userDto.getId() + " was updated");
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
