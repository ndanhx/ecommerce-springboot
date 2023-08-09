package com.ecommerce.customer.customer.Controller;

import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.service.CustomerService;
import com.ecommerce.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/check-out")
    public String checkout(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        Customer customer = customerService.findByUsername(principal.getName());
        String phoneNumber = customer.getPhoneNumber();
        String address = customer.getAddress();
        String city = customer.getCity();
        String country = customer.getCountry();
        if (phoneNumber == null || phoneNumber.trim().isEmpty() ||
                address == null || address.trim().isEmpty() ||
                city == null || city.trim().isEmpty() ||
                country == null || country.trim().isEmpty()) {

            model.addAttribute("customer", customer);
            model.addAttribute("errors", "Update Information Before Checkout");
            return "account";
        } else {
            ShoppingCart cart = customer.getCart();
            if (cart == null) {
                return "redirect:/home";
            } else {
                model.addAttribute("customer", customer);
                model.addAttribute("cart", cart);
            }

        }
        return "check-out";
    }


    @GetMapping("/order")
    public String order(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findByUsername(principal.getName());
        List<Order> orderList = customer.getOrders();
        model.addAttribute("orders", orderList);
        return "order";
    }

    @GetMapping("/save-order")
    public String saveOrder(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findByUsername(principal.getName());
        ShoppingCart cart = customer.getCart();
        orderService.saveOrder(cart);
        return "redirect:/order";
    }
}
