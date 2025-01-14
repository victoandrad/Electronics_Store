package com.victoandrad.Electronics_Store.controllers;

import com.victoandrad.Electronics_Store.models.user.User;
import com.victoandrad.Electronics_Store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = this.service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = this.service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User obj = this.service.insert(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User obj, @PathVariable Long id) {
        User user = this.service.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
