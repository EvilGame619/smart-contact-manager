package com.scm20.demo.Service;


import com.scm20.demo.entities.UserEntity;



import java.util.List;
import java.util.Optional;


public interface UserService {

        UserEntity createUser(UserEntity user);
        Optional<UserEntity> getUserById(Long id);
        Optional<UserEntity> updateUser(UserEntity user);
        void deleteUser(Long id);
        boolean isUserExist(Long id);
        boolean isUserExistByEmail(String email);
        List<UserEntity> getAllUser();
        UserEntity getUserByEmail(String email);
}
