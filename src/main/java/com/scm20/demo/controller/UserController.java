package com.scm20.demo.controller;

import com.scm20.demo.Service.UserService;
import com.scm20.demo.entities.UserEntity;
import com.scm20.demo.helpers.helper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;


//  dashboard
    @GetMapping("/dashboard")
    public String dashboard(){
        return "user/dashboard";
    }
//  profile
    @GetMapping("/profile")
    public String profile(Model model,Authentication authentication){

        return "user/profile";
    }
//  viewContacts
//  addContacts
//  deleteContacts
//  updateContacts
}
