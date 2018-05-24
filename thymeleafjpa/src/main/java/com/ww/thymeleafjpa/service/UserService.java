package com.ww.thymeleafjpa.service;

import com.ww.thymeleafjpa.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

   List<User> getUserList();

   Optional<User> findUserById(Long id);

   User addUser(User user);

   User editUser(User user);

   void  deleteUserById(Long id);

}
