package com.victoandrad.Electronics_Store.services;

import com.victoandrad.Electronics_Store.entities.Order;
import com.victoandrad.Electronics_Store.repositories.OrderRepository;
import com.victoandrad.Electronics_Store.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
