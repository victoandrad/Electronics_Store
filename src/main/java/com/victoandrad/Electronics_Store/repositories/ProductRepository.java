package com.victoandrad.Electronics_Store.repositories;

import com.victoandrad.Electronics_Store.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
