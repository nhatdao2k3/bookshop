package com.group2.bookshopwebsite.controller.admin;

import com.group2.bookshopwebsite.controller.common.BaseController;
import com.group2.bookshopwebsite.entity.Order;
import com.group2.bookshopwebsite.entity.OrderDetail;
import com.group2.bookshopwebsite.service.OrderDetailService;
import com.group2.bookshopwebsite.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/orders_management")
@AllArgsConstructor
public class AdminOrderController extends BaseController {

    private final OrderService orderService;
    private OrderDetailService orderDetailService;

    @GetMapping
    public String getAllOrders(@RequestParam(value = "status", required = false) String status, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        List<Order> orders = orderService.getAllOrders(sort);
    
        if (status != null && !status.isEmpty()) {
            orders = orders.stream()
                    .filter(order -> status.equals(order.getStatus()))
                    .toList();
        }
    
        model.addAttribute("orders", orders);
        model.addAttribute("selectedStatus", status);
        return "admin/orders";
    }

    @GetMapping("/details/{id}")
    public String details(Model model, @PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetailByOrder(order);
        model.addAttribute("order", order);

        model.addAttribute("ordersDetails", orderDetails);

        return "admin/order_detail";
    }

    @GetMapping("/details/process/{id}")
    public String process(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        orderService.setProcessingOrder(order);

        return "redirect:/admin/orders_management/details/" + id;
    }

    @GetMapping("/details/deliver/{id}")
    public String deliver(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        orderService.setDeliveringOrder(order);

        return "redirect:/admin/orders_management/details/" + id;
    }

    @GetMapping("/details/delivered/{id}")
    public String delivered(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        orderService.setDeliveredOrder(order);

        return "redirect:/admin/orders_management/details/" + id;
    }

    @GetMapping("/details/cancel/{id}")
    public String cancel(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);
        orderService.cancelOrder(order);

        return "redirect:/admin/orders_management/details/" + id;
    }
}
