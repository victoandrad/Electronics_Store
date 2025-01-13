package com.victoandrad.Electronics_Store.repositories;

import com.victoandrad.Electronics_Store.models.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
