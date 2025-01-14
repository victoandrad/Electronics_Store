package com.victoandrad.Electronics_Store.services;

import com.victoandrad.Electronics_Store.models.user.User;
import com.victoandrad.Electronics_Store.repositories.UserRepository;
import com.victoandrad.Electronics_Store.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = this.repository.getReferenceById(id);
        this.updateData(entity, obj);
        return this.insert(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
