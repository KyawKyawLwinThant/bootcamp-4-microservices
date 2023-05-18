package com.example.apisecurity.data;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User,Long> {
    Optional<User>  findByEmail(String email);
}
