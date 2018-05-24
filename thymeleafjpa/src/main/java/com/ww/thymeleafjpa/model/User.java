package com.ww.thymeleafjpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    //用户姓名
    @Column(nullable = false, unique = true)
    private String name;

    //用户年龄
    @Column(nullable = false)
    private Integer age;

    //用户生日
    @Column(nullable = false)
    private String birthday;
}
