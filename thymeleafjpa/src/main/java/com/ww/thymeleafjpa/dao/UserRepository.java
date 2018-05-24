package com.ww.thymeleafjpa.dao;

import com.ww.thymeleafjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
