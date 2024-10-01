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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
public class RootController {

    Logger logger = LoggerFactory.getLogger(RootController.class);
    private final UserService userService;

    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication){
        if(authentication==null){
            return;
        }
        logger.info("adding model");
        String username = helper.getEmailOfLoggedInUser(authentication);
        logger.info("user logged in : "+ username);

        UserEntity user = userService.getUserByEmail(username);
        model.addAttribute("loggedInUser",user);
    }
}
