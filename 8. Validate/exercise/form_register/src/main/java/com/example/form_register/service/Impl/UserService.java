package com.example.form_register.service.Impl;

import com.example.form_register.model.User;
import com.example.form_register.repository.IUserRepository;
import com.example.form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> findAll(){
        return iUserRepository.findAll();
    }
}
