package com.victoandrad.Electronics_Store.resources;

import com.victoandrad.Electronics_Store.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Victor Andrade", "victor@gmail.com", "43991172893", "victor");
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
