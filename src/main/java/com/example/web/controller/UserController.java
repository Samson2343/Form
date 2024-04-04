package com.example.web.controller;


import com.example.web.model.User;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/form")
public class UserController {

    @Autowired
    private UserService userService;



    @CrossOrigin
    @PostMapping(path="/register/{age}")
    public ResponseEntity<String> registerUser(@PathVariable("age") int age,
                                                @RequestHeader("X-custom-header") int myNumber,
                                                @RequestParam("firstname") String firstname,
                                               @RequestParam("lastname") String lastname,
                                               @RequestParam("city") String city,
                                                @RequestParam("state") String state,
                                                @RequestParam("country") String country,
                                               @RequestParam("email") String email,
                                               @RequestParam("phone") String phone,
                                                @RequestParam(value = "file",required = false) MultipartFile file){


        System.out.println("multi"+age+myNumber);
        try{
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setCity(city);
            user.setState(state);
            user.setAge(age);
            user.setCountry(country);
            user.setEmail(email);
            user.setPhone(phone);
            user.setProfile(file.getBytes());
            userService.save(user);
        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("User registered successfully");
    }

    @CrossOrigin
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers =  userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
