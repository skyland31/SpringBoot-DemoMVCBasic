package com.example.demomvc.controller;

import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.service.IUserServiceIm;
import com.example.demomvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestMainController {
    @Autowired
    private  UserService  userService;

    @Autowired
    private IUserServiceIm userServiceIm;


    @RequestMapping(value = "/getAllUserJson")
     public List<UserEntity> getAllUser() {
            return userService.getAllUser();
    }

    //การทำ Pagination and Sorting
    //ใช้ @PathVariable วิธีการเข้าถึงคือ /user/0/5
    @RequestMapping("/user/{pageNo}/{pageSize}/{order}") //ทำpagination
    public List<UserEntity> getPaginatedCountries(
            @PathVariable int pageNo,
            @PathVariable int pageSize,
            @PathVariable String order )
    {
        return userServiceIm.findPaginated(pageNo, pageSize,order);
    }
}
