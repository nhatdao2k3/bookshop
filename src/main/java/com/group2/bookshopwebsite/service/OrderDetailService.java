package com.group2.bookshopwebsite.service;

import com.group2.bookshopwebsite.entity.Order;
import com.group2.bookshopwebsite.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetailByOrder(Order order);
}
