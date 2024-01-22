package com.schoolmanagement.school.service;

import com.schoolmanagement.school.entity.Credentials;
import com.schoolmanagement.school.exception.IncorrectPasswordException;
import com.schoolmanagement.school.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Boolean checkPassword(String username, String password) {
        List<Credentials> storedCredentials = loginRepository.findByUsername(username);
        for (Credentials storedcredential : storedCredentials) {
            if (password.equals(storedcredential.getPassword())) {
                return true ;
            }
            else {
                return false ;
            }
        }
        throw new IncorrectPasswordException("Incorrect password");
    }
}
