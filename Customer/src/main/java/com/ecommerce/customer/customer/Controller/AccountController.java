package com.ecommerce.customer.customer.Controller;

import com.ecommerce.library.model.City;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.repository.CityRepository;
import com.ecommerce.library.service.CityService;
import com.ecommerce.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("account")
    public String accountHome(Model model, Principal principal){
        if (principal == null) {
            return "redirect:/login";
        }
        Customer customer = customerService.findByUsername(principal.getName());
        model.addAttribute("customer", customer);

        return "account";
    }

    @RequestMapping( value = "/update-info-customer", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCustomer(Model model,
                                 Principal principal,
                                 RedirectAttributes attributes,
                                 @ModelAttribute("customer") Customer customer){

        if (principal == null) {
            return "redirect:/login";
        }
        Customer customerSaved =  customerService.saveInfo(customer);
        attributes.addFlashAttribute("customer", customerSaved);
        return "redirect:/account";
    }



}
