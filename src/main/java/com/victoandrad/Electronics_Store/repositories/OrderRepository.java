package com.victoandrad.Electronics_Store.repositories;

import com.victoandrad.Electronics_Store.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
