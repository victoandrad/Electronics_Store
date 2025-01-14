package com.victoandrad.Electronics_Store.services;

import com.victoandrad.Electronics_Store.models.product.Product;
import com.victoandrad.Electronics_Store.repositories.ProductRepository;
import com.victoandrad.Electronics_Store.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
