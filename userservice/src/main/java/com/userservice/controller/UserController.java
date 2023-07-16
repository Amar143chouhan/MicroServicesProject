package com.userservice.controller;
import com.userservice.entities.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

//create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

     User u = userService.saveUser(user);

          return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }
    //single user

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String id)
    {

       User user = userService.getUser(id);

       return ResponseEntity.ok(user);
    }
    //multipleuser

    @GetMapping
    public ResponseEntity<List<User>> getALlUser()
    {

        List<User>  list= userService.getAllUser();

        return  ResponseEntity.ok(list);
    }


}

