package com.scm20.demo.controller;

import com.scm20.demo.Service.ContactService;
import com.scm20.demo.Service.ImageService;
import com.scm20.demo.Service.UserService;
import com.scm20.demo.entities.ContactEntity;
import com.scm20.demo.entities.UserEntity;
import com.scm20.demo.entities.enums.MessageType;
import com.scm20.demo.forms.AddContactForm;
import com.scm20.demo.forms.Message;
import com.scm20.demo.forms.SearchForm;
import com.scm20.demo.helpers.Constant;
import com.scm20.demo.helpers.helper;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/contacts")
public class ContactsController {

    private final ImageService imageService;
    private final UserService userService;
    private final ContactService contactService;
    Logger logger = LoggerFactory.getLogger(ContactsController.class);
    private final ModelMapper mapper;
    @GetMapping("/add")
    public String addContactView(Model model) {
        AddContactForm contactForm = new AddContactForm();
        model.addAttribute("contactform", contactForm); // Use "contactform"
        return "user/add_contact";
    }

    @PostMapping("/add")
    public String contactAdd(@Valid @ModelAttribute("contactform") AddContactForm contactForm,
                             BindingResult bindingResult,
                             Authentication authentication, HttpSession session) {
        if (bindingResult.hasErrors()) {
            session.setAttribute("message", Message.builder().message("Please correct the following erros").type(MessageType.red).build());
            return "user/add_contact"; // Ensure this matches the template
        }

        String username = helper.getEmailOfLoggedInUser(authentication);
        UserEntity user = userService.getUserByEmail(username);
        String fileName = UUID.randomUUID().toString();
        String fileURL = imageService.uploadImage(contactForm.getPicture(),fileName);
        ContactEntity contact = new ContactEntity();
        contact.setUser(user);
        contact.setEmail(contactForm.getEmail());
        contact.setAddress(contactForm.getAddress());
        contact.setName(contactForm.getName());
        contact.setDescription(contactForm.getDescription());
        contact.setFavourite(contactForm.isFavourite());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setLinkedLink(contactForm.getLinkedLink());
        contact.setWebsiteLink(contactForm.getWebsiteLink());
        contact.setPicture(fileURL);
        contact.setCloudinaryID(fileName);
        contactService.save(contact);
        session.setAttribute("message", Message.builder().message("Your contact is successfully saved").type(MessageType.green).build());
        System.out.println(contact);
        return "redirect:/user/contacts/add";
    }

    @GetMapping
    public String viewContacts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "sortBy",defaultValue = "name") String sortBy,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            Model model,Authentication authentication){
        String username = helper.getEmailOfLoggedInUser(authentication);
        UserEntity user = userService.getUserByEmail(username);
        Page<ContactEntity> pageContacts = contactService.getAllContacts(user,page, size, sortBy, direction);
        model.addAttribute("pageContacts",pageContacts);
        model.addAttribute("searchForm",new SearchForm());
        return "user/contact";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute SearchForm searchForm, @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "3") int size,
                         @RequestParam(value = "sortBy",defaultValue = "name") String sortBy,
                         @RequestParam(value = "direction", defaultValue = "asc") String direction, Model model, Authentication authentication){
        Page<ContactEntity> pageContacts=null;
        var userName = helper.getEmailOfLoggedInUser(authentication);
        var user = userService.getUserByEmail(userName);
        if(searchForm.getField().equalsIgnoreCase("name")){
            pageContacts=contactService.searchByName(searchForm.getKeyword(),page,size,sortBy,direction,user);
        } else if (searchForm.getField().equalsIgnoreCase("phone")) {
            pageContacts=contactService.searchByPhone(searchForm.getKeyword(),page,size,sortBy,direction,user);
        }else if(searchForm.getField().equalsIgnoreCase("email")){
            pageContacts = contactService.searchByEmail(searchForm.getKeyword(),page,size,sortBy,direction,user);
        }
        model.addAttribute("pageContacts",pageContacts);
        model.addAttribute("searchForm",searchForm);

        logger.info("page {}",pageContacts);
        return "user/search";
    }
}
