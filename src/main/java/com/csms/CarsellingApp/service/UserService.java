package com.csms.CarsellingApp.service;


import com.csms.CarsellingApp.entity.Role;
import com.csms.CarsellingApp.entity.User;
import com.csms.CarsellingApp.repository.RoleRepository;
import com.csms.CarsellingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAllUsers(){
        var users = userRepository.findAll();
        return users;
    }

    public User createNewUser(User userObj){
        Role role = roleRepository.findById(600).get();
        userObj.getRoles().add(role);
        User user = userRepository.save(userObj);
        return user;
    }

    public User updateUser(Integer userId , User obj){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setAddress(obj.getAddress());
        existingUser.setCity(obj.getCity());
        existingUser.setName(obj.getName());
        existingUser.setPhone(obj.getPhone());
        var savedUser =  userRepository.save(existingUser);
        return savedUser;
    }

    public void deleteUser(Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
