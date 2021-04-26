package com.restService.controller;

import com.restService.model.UserList;
import com.restService.repositories.UserListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiUserListController {

    @Autowired
    private UserListRepo userListRepo;

    @GetMapping("/user")
    public ResponseEntity<List<UserList>> GetAllUser()
    {
        try
        {
            List<UserList> user = this.userListRepo.findAll();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Object> SaveUser(@RequestBody UserList user) {
        UserList userData = this.userListRepo.save(user);
        try {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception exception) {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserList>> GetUserById(@PathVariable("id") Long id)
    {
        try
        {
            Optional<UserList> user = this.userListRepo.findById(id);
            if(user.isPresent())
            {
                ResponseEntity rest = new ResponseEntity<>(user, HttpStatus.OK);
                return rest;
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
