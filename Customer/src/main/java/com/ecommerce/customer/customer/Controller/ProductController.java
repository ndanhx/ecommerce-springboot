package com.ecommerce.customer.customer.Controller;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Product> listViewProducts = productService.listViewProducts();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndSize();
        model.addAttribute("title", "Product");
        model.addAttribute("products", products);
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("viewProducts", listViewProducts);
        return "shop";
    }

    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        Long categoryId = product.getCategory().getId();
        List<Product> products = productService.getRelatedProducts(categoryId);
        model.addAttribute("products", products);
        model.addAttribute("title", "Product Detail");
        model.addAttribute("productDetail", product);
        return "product-detail";
    }

    @GetMapping("/products-in-category/{id}")
    public String getProductsInCategory(@PathVariable("id") Long categoryId, Model model) {
        Category category = categoryService.findById(categoryId);
        List<Product> productList = productService.getProductByCategory(categoryId);
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndSize();
        model.addAttribute("title", "Product");
        model.addAttribute("products", productList);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryDtoList);
        return "product-in-category";
    }

    @GetMapping("/high-price")
    public String filterHighPrice(Model model) {
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndSize();
        List<Product> products = productService.filterHighPrice();
        model.addAttribute("title", "Product High Price");
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "filter-high-price";
    }

    @GetMapping("/low-price")
    public String filterLowerPrice(Model model) {
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndSize();
        List<Product> products = productService.filterLowerPrice();
        model.addAttribute("title", "Product Low Price");
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "filter-low-price";
    }

}
