package com.ww.thymeleafjpa.controller;

import com.ww.thymeleafjpa.model.User;
import com.ww.thymeleafjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


/*使用@Controller而不用@RESTController是因为这里返回一个页面而不是一个值，
如果只是使用@RestController注解Controller，则Controller中的方法无法返回页面，
配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容*/
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String UserList(Model model){
        model.addAttribute("users", userService.getUserList());
        return "userlist";
    }


    @GetMapping("/toAdd")
    public String toAdd() {
        return "useradd";
    }

    @PostMapping("/add")
    public String UserAdd(@RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("birthday") String birthday){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setBirthday(birthday);
       // System.out.println(user);
        userService.addUser(user);
        //redirect的是url地址；而直接返回的是html，url地址不会变
        return "redirect:/list";
    }

    @GetMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Optional<User> user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "useredit";
    }

    @PostMapping("/edit")
    public String edit(User user) {
        System.out.println(user);
        userService.editUser(user);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String deleteById(Long id) {
        userService.deleteUserById(id);
        return "redirect:/list";
    }

}
