package com.ecommerce.admin.controller;

import com.ecommerce.library.model.Order;
import com.ecommerce.library.repository.OrderRepository;
import com.ecommerce.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/orders")
    public String order(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("title", "Customer's Order");
        model.addAttribute("orders", orderList);
        return "order";
    }

    @GetMapping("/accept-order/{id}")
    public String acceptOrder(@PathVariable("id") Long orderId, Model model){
        orderService.acceptOrder(orderId);
        return "redirect:/orders";
    }

    @GetMapping("/delete-order/{id}")
    public String deleteOrder(@PathVariable("id") Long orderId, Model model){
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }

}
