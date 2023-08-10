package com.ecommerce.admin.controller;

import com.ecommerce.library.dto.AdminDto;
import com.ecommerce.library.model.Admin;
import com.ecommerce.library.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("adminDto",new AdminDto());
        model.addAttribute("title", "Register");
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forGotPassword(Model model){

        model.addAttribute("title", "Forgot Password");
        return "forgot-password";

    }

    @PostMapping("/register-new")
    public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto,
                              BindingResult result,
                              Model model){
       try {
           if (result.hasErrors()){
               model.addAttribute("adminDto", adminDto);
               return "register";
           }
           Admin admin = adminService.findByUsername(adminDto.getUsername());
           if(admin != null){
               model.addAttribute("adminDto", adminDto);
               System.out.println("admin not null");
               model.addAttribute("emailError","Your email has been registered");
               return "register";
           }
           if(adminDto.getPassword().equals(adminDto.getRepeatPassword())){
               adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
               adminService.save(adminDto); //insert account admin vào dabase
               System.out.println("success");
               model.addAttribute("success","Register Successfully");

               model.addAttribute("adminDto", adminDto);
           }else {
               model.addAttribute("adminDto", adminDto);
               System.out.println("password is not same");
               model.addAttribute("passwordError","Your repass wrong! Check again");

               return "register";
           }



       }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errors","Server error");

       }
        return "register";

    }
}
