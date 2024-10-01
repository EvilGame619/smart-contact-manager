package com.scm20.demo.Service.implementations;

import com.scm20.demo.Exceptions.ResourceNotFoundException;
import com.scm20.demo.Repository.ContactRepository;
import com.scm20.demo.Service.ContactService;
import com.scm20.demo.entities.ContactEntity;
import com.scm20.demo.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImplementation implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    @Override
    public ContactEntity save(ContactEntity contact) {
        return contactRepository.save(contact);
    }

    @Override
    public ContactEntity update(ContactEntity contact, Long id) {
        ContactEntity contact1 = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found with id: "+id));
        var newUser =  modelMapper.map(contact,ContactEntity.class);
        return contactRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public ContactEntity getById(Long id) {
        return contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found with id: "+id));
    }

    @Override
    public Page<ContactEntity> getAllContacts(UserEntity user, int page, int size, String sortBy, String direction) {
        Sort sort = direction.equals("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        var pageable = PageRequest.of(page,size,sort);
        return contactRepository.findByUser(user, pageable);
    }

    @Override
    public Page<ContactEntity> searchByName(String name, int page, int size, String sortBy, String direction,UserEntity user) {
        Sort sort = direction.equals("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        var pageable = PageRequest.of(page,size,sort);
        return contactRepository.findByUserAndNameContaining(user,name,pageable);
    }

    @Override
    public Page<ContactEntity> searchByEmail(String email, int page, int size, String sortBy, String direction,UserEntity user) {
        Sort sort = direction.equals("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        var pageable = PageRequest.of(page,size,sort);
        return contactRepository.findByUserAndEmailContaining(user,email,pageable);
    }

    @Override
    public Page<ContactEntity> searchByPhone(String phone, int page, int size, String sortBy, String direction,UserEntity user) {
        Sort sort = direction.equals("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        var pageable = PageRequest.of(page,size,sort);
        return contactRepository.findByUserAndPhoneNumberContaining(user,phone,pageable);
    }



}
