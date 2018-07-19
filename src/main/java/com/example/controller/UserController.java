package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;



    //Update user failed --please check
    @RequestMapping("/updateUser")
    public int  UpdateUser(@RequestParam("id") Long id, @RequestParam("email") String email)
    {
      int result=  userRepository.modifyEmail1(id,email);
      return result;
    }


    @RequestMapping("/findByUserName")
    public User FindByUserName(@RequestParam("userName") String userName)
    {
        User user=userRepository.findByUserName(userName);
        return user;
    }


    @RequestMapping("/delete")
    public void DeleteByUserId(@RequestParam("id") long id )
    {
        userRepository.deleteByUserId(id);
    }


}
