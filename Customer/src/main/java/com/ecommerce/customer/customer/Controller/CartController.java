package com.ecommerce.customer.customer.Controller;

import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.service.CustomerService;
import com.ecommerce.library.service.ProductService;
import com.ecommerce.library.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping("/cart")
    public String cart(Model model, Principal principal) {
        model.addAttribute("title", "Cart");
        if (principal == null) {
            return "redirect:/login";
        }
        try {
            Customer customer = customerService.findByUsername(principal.getName()); // getName is username in session
            ShoppingCart shoppingCart = customer.getCart();
            if (shoppingCart == null) {
                model.addAttribute("check", "No item in cart");
                model.addAttribute("subTotal", 0);
            }else{
                model.addAttribute("shoppingCart", shoppingCart);
                model.addAttribute("subTotal", shoppingCart.getTotalPrices());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addItemToCart(@RequestParam("id") Long productId,
                                @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,
                                Principal principal,
                                Model model,
                                HttpServletRequest request) {
        if (principal == null) {
            return "redirect:/login";
        }
        Product product = productService.findById(productId);
        Customer customer = customerService.findByUsername(principal.getName());
        ShoppingCart cart = cartService.addItemToCart(product, quantity, customer);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=update")
    public String updateCart(@RequestParam("id") Long productId,
                             @RequestParam(value = "quantity") int quantity,
                             Principal principal,
                             Model model
    ) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            Customer customer = customerService.findByUsername(principal.getName());
            Product product = productService.findById(productId);
            ShoppingCart cart = cartService.updateItemToCart(product, quantity, customer);
            model.addAttribute("shoppingCart", cart);
            return "redirect:/cart";

        }

    }

    @RequestMapping(value = "/update-cart",method= RequestMethod.POST, params = "action=delete")
    public String deletedCart(@RequestParam("id") Long productId,
                              Principal principal,
                              Model model) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            Customer customer = customerService.findByUsername(principal.getName());
            Product product = productService.findById(productId);
            ShoppingCart cart = cartService.deleteItemToCart(product, customer);
            model.addAttribute("shoppingCart", cart);
            return "redirect:/cart";
        }


    }


}
