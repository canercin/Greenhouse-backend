package dev.canercin.greenhouseiot.rest;

import dev.canercin.greenhouseiot.entities.User;
import dev.canercin.greenhouseiot.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
>>>>>>> 6670f8a (get last 10 record added)

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
<<<<<<< HEAD
    private UserService userService;
=======
    private final UserService userService;
>>>>>>> 6670f8a (get last 10 record added)

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.findAll();
    }
<<<<<<< HEAD
=======

    @DeleteMapping("{id}")
    public HttpStatus deleteUser(@PathVariable("id") String id){
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }
>>>>>>> 6670f8a (get last 10 record added)
}
