package com.group2.bookshopwebsite.repository;

import com.group2.bookshopwebsite.entity.Order;
import com.group2.bookshopwebsite.entity.OrderDetail;
import com.group2.bookshopwebsite.entity.composite_key.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    List<OrderDetail> findByOrder(Order order);
}
