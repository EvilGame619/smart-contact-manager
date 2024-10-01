package com.scm20.demo.Repository;

import com.scm20.demo.entities.ContactEntity;
import com.scm20.demo.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    Page<ContactEntity> findByUser(UserEntity user, Pageable pageable);
    Page<ContactEntity> findByUserAndNameContaining(UserEntity user,String name, Pageable pageable);
    Page<ContactEntity> findByUserAndEmailContaining(UserEntity user, String email, Pageable pageable);
    Page<ContactEntity> findByUserAndPhoneNumberContaining(UserEntity user,String phoneNumber, Pageable pageable);

}
