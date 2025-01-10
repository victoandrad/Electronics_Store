package com.victoandrad.Electronics_Store.repositories;

import com.victoandrad.Electronics_Store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
