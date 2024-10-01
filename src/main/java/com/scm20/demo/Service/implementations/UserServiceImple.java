package com.scm20.demo.Service.implementations;

import com.scm20.demo.Exceptions.ResourceNotFoundException;
import com.scm20.demo.Repository.UserRepository;
import com.scm20.demo.Service.UserService;
import com.scm20.demo.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    @Override
    public UserEntity createUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("ROLE_USER"));
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> updateUser(UserEntity user) {
        UserEntity theUser = userRepository.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found with the id: "+user.getUserId()));
        var newUser = mapper.map(user, UserEntity.class);
        UserEntity savedUser = userRepository.save(newUser);
        return Optional.ofNullable(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity theUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with the id: "+ id));
        userRepository.delete(theUser);
    }

    @Override
    public boolean isUserExist(Long id) {
        UserEntity theUser = userRepository.findById(id).orElse(null);
        return theUser != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        UserEntity theUser = userRepository.findUserByEmail(email).orElse(null);
        return theUser != null;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
