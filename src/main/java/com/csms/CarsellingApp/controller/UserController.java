package com.csms.CarsellingApp.controller;

import com.csms.CarsellingApp.entity.User;
import com.csms.CarsellingApp.repository.UserRepository;
import com.csms.CarsellingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers() , HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User obj){
         return new ResponseEntity<>(userService.createNewUser(obj) , HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User obj , @PathVariable Integer userId){
        return new ResponseEntity<>(userService.updateUser(userId , obj) , HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String>   deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User removed successfully!!"  , HttpStatus.OK);
    }
}
