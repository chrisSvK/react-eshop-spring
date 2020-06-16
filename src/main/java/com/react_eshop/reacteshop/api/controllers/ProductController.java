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

    @GetMapping(value = {"getAllProducts", "getAllProducts/{filter}"})
    public List<Produkt> getAllProducts(@PathVariable(name = "filter", required = false) String filter) {
        if (filter != null) {
            switch (filter) {
                case "filter2":
                    return productService.findAll(2);
                case "filter3":
                    return productService.findAll(3);
                case "filter4":
                    return productService.findAll(4);
                case "filter5":
                    return productService.findAll(5);
                case "filter6":
                    return productService.findAll(6);
                case "filter7":
                    return productService.findAll(7);
                default:
                    return productService.findAll(1);
            }
        } else
            return productService.findAll(1);
    }

    @GetMapping(value={"{category}/{filter}", "{category}"})
    public List<Produkt> findByCategory(@PathVariable(name = "category") Integer category, @PathVariable(name = "filter", required = false) String filter) {
        if (filter != null) {
            switch (filter) {
                case "filter2":
                    return productService.findByCategory(category, 2);
                case "filter3":
                    return productService.findByCategory(category, 3);
                case "filter4":
                    return productService.findByCategory(category, 4);
                case "filter5":
                    return productService.findByCategory(category, 5);
                case "filter6":
                    return productService.findByCategory(category, 6);
                case "filter7":
                    return productService.findByCategory(category, 7);
                default:
                    return productService.findByCategory(category, 1);
            }
        } else
        return productService.findByCategory(category, 1);
    }

    @GetMapping("getPopular")
    public List<Produkt> findPopular() {
        return productService.findPopular();
    }
}
