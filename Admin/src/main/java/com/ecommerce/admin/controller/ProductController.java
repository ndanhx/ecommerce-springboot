package com.ecommerce.admin.controller;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/products")
    private String products(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        List<ProductDto> productDtoList = productService.findAll();
        model.addAttribute("title", "Product");
        model.addAttribute("products", productDtoList);
        model.addAttribute("size", productDtoList.size());
        return "products";
    }

    @GetMapping("products/{pageNo}")
    public String productPage(@PathVariable("pageNo")int pageNo, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        Page<ProductDto> products= productService.pageProducts(pageNo);
        model.addAttribute("title", "Products");
        model.addAttribute("size", products.getSize());
        model.addAttribute("products", products);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", products.getTotalPages());
        return "products";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAllByActivated();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDto());

        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("product") ProductDto productDto,
                              @RequestParam("imageProduct") MultipartFile imageProduct,
                              RedirectAttributes attributes ){
        try {
            productService.save(imageProduct, productDto);
            attributes.addFlashAttribute("success", "Added Product Successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Failed to Add Product");
        }
        return "redirect:/products/0";
    }

    @GetMapping("/update-product/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model){
       try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
                return "redirect:/login";
            }
            model.addAttribute("title", "Update Product");
            List<Category> categories = categoryService.findAllByActivated();
            ProductDto productDto = productService.getById(id);
            model.addAttribute("product", productDto);
            model.addAttribute("category", categories);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "update-product";
    }
    @PostMapping("/update-product/{id}")
    public String processUpdateProduct(@PathVariable("id") Long id,
                                       @ModelAttribute("productDto") ProductDto productDto,
                                       @RequestParam("imageProduct")MultipartFile imageProduct,
                                       RedirectAttributes attributes){
        try {
            productService.update(imageProduct, productDto);
            attributes.addFlashAttribute("success","Update Successfully");

        } catch (Exception e) {
            attributes.addFlashAttribute("error","Update Failed !");
            e.printStackTrace();
        }

        return "redirect:/products/0";
    }

    @RequestMapping(value = "/enable-product/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String enableProduct(@PathVariable("id") Long id,
                                RedirectAttributes attributes){
        try {
            productService.enableById(id);
            attributes.addFlashAttribute("success", "Enable Product Successfully !");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Failed Enable Product !");
            e.printStackTrace();
        }
        return "redirect:/products/0";
    }

    @RequestMapping(value = "/delete-product/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String deleteProduct(@PathVariable("id") Long id,
                                RedirectAttributes attributes){
        try {
            productService.deletedById(id);
            attributes.addFlashAttribute("success", "Deleted Product Successfully !");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Failed Delete Product !");
            e.printStackTrace();
        }
        return "redirect:/products/0";
    }
    @GetMapping("/search-result/{pageNo}")
    public String searchProducts(@PathVariable("pageNo") int pageNo,
                                 @RequestParam("keyword") String keyword,
                                 Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        Page<ProductDto> products = productService.searchProducts(pageNo,keyword );
        model.addAttribute("title", "Search Result Product");
        model.addAttribute("product", products);
        model.addAttribute("size", products.getSize());
        model.addAttribute("size", products.getSize());
        model.addAttribute("products", products);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", products.getTotalPages());
        return "result-products";
    }





}
