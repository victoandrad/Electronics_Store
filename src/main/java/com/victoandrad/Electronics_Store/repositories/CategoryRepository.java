package com.victoandrad.Electronics_Store.repositories;

import com.victoandrad.Electronics_Store.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
