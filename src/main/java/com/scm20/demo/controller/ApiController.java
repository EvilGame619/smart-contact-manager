package com.scm20.demo.controller;

import com.scm20.demo.Service.ContactService;
import com.scm20.demo.entities.ContactEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ContactService contactService;

    @GetMapping("/contact/{id}")
    public ContactEntity getContact(@PathVariable Long id){
        return contactService.getById(id);
    }
}
