package com.example.apisecurity.service;

import com.example.apisecurity.data.User;
import com.example.apisecurity.data.UserDao;
import com.example.apisecurity.exception.PasswordNotMatchError;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User register(String firstName,String lastName,
                         String email,String password,String confirmPassword){
        if(!password.equals(confirmPassword)){
            throw new PasswordNotMatchError();
        }
        return userDao.save(
                User.of(firstName,lastName,email,password)
        );
    }


}
