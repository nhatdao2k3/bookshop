package com.group2.bookshopwebsite.service.impl;

import com.group2.bookshopwebsite.entity.Order;
import com.group2.bookshopwebsite.entity.OrderDetail;
import com.group2.bookshopwebsite.repository.OrderDetailRepository;
import com.group2.bookshopwebsite.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> getAllOrderDetailByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }
}
