package com.scm20.demo.Service;

import com.scm20.demo.entities.ContactEntity;
import com.scm20.demo.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    ContactEntity save(ContactEntity contact);
    ContactEntity update(ContactEntity contact, Long id);
    void delete(Long id);
    ContactEntity getById(Long id);

    Page<ContactEntity> getAllContacts(UserEntity user, int page, int size, String sortBy, String direction);
    Page<ContactEntity> searchByName(String name,int page, int size, String sortBy, String direction,UserEntity user);
    Page<ContactEntity> searchByEmail(String email,int page, int size, String sortBy, String direction,UserEntity user);
    Page<ContactEntity> searchByPhone(String phone,int page, int size, String sortBy, String direction,UserEntity user);

}
