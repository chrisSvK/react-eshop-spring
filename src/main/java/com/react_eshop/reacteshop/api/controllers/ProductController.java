package com.react_eshop.reacteshop.api.controllers;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import com.react_eshop.reacteshop.api.services.ProductService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAllProducts")
    public List<Produkt> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("{category}")
    public List<Produkt> findByCategory(@PathVariable(name = "category") Integer category) {
        System.out.println(category);
        return productService.findByCategory(category);
    }

    @GetMapping("getPopular")
    public List<Produkt> findPopular() {
        return productService.findPopular();
    }
}
