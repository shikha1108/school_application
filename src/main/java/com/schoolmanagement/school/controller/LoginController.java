package com.schoolmanagement.school.controller;

import com.schoolmanagement.school.entity.Credentials;
import com.schoolmanagement.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public Boolean checkPassword(@Validated @RequestBody Credentials credentials) {
        String username = credentials.getUsername();
       return loginService.checkPassword(username, credentials.getPassword());
    }
}
