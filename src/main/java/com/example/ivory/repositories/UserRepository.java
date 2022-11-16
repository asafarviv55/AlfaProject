package com.example.ivory.repositories;

import com.example.ivory.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where username = ? and password = ? ", nativeQuery = true)
    List<User> login(String username, String password);

}
