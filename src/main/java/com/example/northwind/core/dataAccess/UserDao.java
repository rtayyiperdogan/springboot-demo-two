package com.example.northwind.core.dataAccess;

import com.example.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Recep Tayyip Erdogan
 * @since : 30-Jun-21, Wed
 **/
public interface UserDao extends JpaRepository<User,Integer> {
    /**I'm using JPA repo for validation*/
    User findByEmail(String email);
}
