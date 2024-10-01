package com.scm20.demo.controller;

import com.scm20.demo.Service.UserService;
import com.scm20.demo.entities.UserEntity;
import com.scm20.demo.entities.enums.MessageType;
import com.scm20.demo.forms.Message;
import com.scm20.demo.forms.UserForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final ModelMapper mapper;
    private final UserService userService;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("name","Khalo.com");
        model.addAttribute("youtubeLink","https://www.youtube.com");
        System.out.println("Home page controller");
        return "home";
    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","Khalo.com");
        model.addAttribute("youtubeLink","https://www.youtube.com");
        System.out.println("Home page controller");
        return "home";
    }
    @RequestMapping("/about")
    public String about(){
        System.out.println("about page loading");
        return "about";
    }
    @RequestMapping("/services")
    public String services(){
        System.out.println("services page loading");
        return "service";
    }
    @RequestMapping("/contact")
    public String contact(){
        System.out.println("contact page loading");
        return "contact";
    }
    @RequestMapping("/signup")
    public String signup(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "signup";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRequest(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        UserEntity user = mapper.map(userForm, UserEntity.class);
        user.setProfileLink("https://images.app.goo.gl/3Mx1ajjJ7bkUzoum8");
        UserEntity theUser=userService.createUser(user);
        Message message = Message.builder()
                .message("Registration Successful")
                .type(MessageType.green)
                .build();
        session.setAttribute("message",message);
        System.out.println(theUser);
        return "redirect:/signup";
    }

}
