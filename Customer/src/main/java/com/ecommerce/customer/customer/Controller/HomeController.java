package com.ecommerce.customer.customer.Controller;


import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.CustomerService;
import com.ecommerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CustomerService customerService;



    @GetMapping({"/home", "/trang-chu", "/index", "/"})
    public String index(Model model, Principal principal, HttpSession session){
        if (principal != null){
            session.setAttribute("username", principal.getName());
            Customer customer = customerService.findByUsername(principal.getName());
            ShoppingCart cart = customer.getCart();
            if (cart == null){
                session.setAttribute("totalItems", 0);
            }else {
                session.setAttribute("totalItems", cart.getTotalItems());
            }

        }else{
            session.removeAttribute("username");
        }

        List<Category> categories = categoryService.findALl();
        List<ProductDto> productDtos = productService.findAll();
        model.addAttribute("title","DuyAnh Restaurant");
        model.addAttribute("categories", categories);
        model.addAttribute("products", productDtos);
        return "index";

    }


}
