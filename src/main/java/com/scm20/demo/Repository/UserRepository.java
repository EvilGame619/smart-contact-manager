package com.scm20.demo.Repository;

import com.scm20.demo.entities.ContactEntity;
import com.scm20.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserByEmail(String email);
    UserEntity getUserByEmail(String email);

}
