package com.example.form_register.repository;

import com.example.form_register.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    List<User> findAll();
}
