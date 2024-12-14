package com.group2.bookshopwebsite.controller;

import com.group2.bookshopwebsite.controller.common.BaseController;
import com.group2.bookshopwebsite.entity.Order;
import com.group2.bookshopwebsite.entity.OrderDetail;
import com.group2.bookshopwebsite.service.OrderDetailService;
import com.group2.bookshopwebsite.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController extends BaseController {

    private OrderService orderService;
    private OrderDetailService orderDetailService;

    @GetMapping
    public String getOrders(Model model) {

        List<Order> orders = orderService.getAllOrdersByUser(getCurrentUser());
        model.addAttribute("orders", orders);
        return "user/orders_list";
    }

    @GetMapping("{id}")
    public String details(Model model, @PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetailByOrder(order);
        model.addAttribute("order", order);

        model.addAttribute("ordersDetails", orderDetails);

        return "user/order_details";
    }
    @GetMapping("cancel/{id}")
    public String cancel(@PathVariable Long id){

        Order order = orderService.getOrderById(id);
        orderService.cancelOrder(order);

        return "redirect:/orders/{id}";
    }
    @GetMapping("received/{id}")
    public String received(@PathVariable Long id){

        Order order = orderService.getOrderById(id);
        orderService.setReceivedToOrder(order);

        return "redirect:/orders/{id}";
    }
}
