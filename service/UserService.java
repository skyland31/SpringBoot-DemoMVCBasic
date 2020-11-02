package com.example.demomvc.service;

import com.example.demomvc.entity.OrganizeEntity;
import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.respository.OrganizeRepository;
import com.example.demomvc.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public void addUserNew(UserEntity user){
        userRepository.save(user);
    }

    public void deleteUser(int id) {

        userRepository.deleteById(id);
    }
    public void updateUser(UserEntity user) {
        UserEntity temp = userRepository.getOne(user.getUserId());
        user.setCreateDate(temp.getCreateDate());
        userRepository.save(user);
    }
    public UserEntity getOne(int id) {
        UserEntity user = userRepository.getOne(id);
        return user;
    }

}

