package com.michal.eventmanagementsystem.repository;

import com.michal.eventmanagementsystem.dto.UserDto;
import com.michal.eventmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long id);

    //User save(User user);
    UserDto save(UserDto userDto);

    User getById(Long id);

    void deleteById(Long id);

    void deleteAll();

}
