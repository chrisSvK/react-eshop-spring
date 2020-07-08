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


    @GetMapping(value = {"getAllProducts", "getAllProducts/{filter}/{priceRange}"})
    public List<Produkt> getAllProducts(@PathVariable(name = "filter", required = false) String filter, @PathVariable(name = "priceRange", required = false) Float priceRange) {
        if (filter != null) {
            switch (filter) {
                case "filter2":
                    return productService.findAll(2, priceRange);
                case "filter3":
                    return productService.findAll(3, priceRange);
                case "filter4":
                    return productService.findAll(4, priceRange);
                case "filter5":
                    return productService.findAll(5, priceRange);
                case "filter6":
                    return productService.findAll(6, priceRange);
                case "filter7":
                    return productService.findAll(7, priceRange);
                default:
                    return productService.findAll(1, priceRange);
            }
        } else
            return productService.findAll(1, 50.0f);
    }

    @GetMapping(value = {"category/{category}/{filter}/{priceRange}", "category/{category}"})
    public List<Produkt> findByCategory(@PathVariable(name = "category") Integer category, @PathVariable(name = "filter", required = false) String filter, @PathVariable(name = "priceRange", required = false) Float priceRange) {
        if (filter != null) {
            switch (filter) {
                case "filter2":
                    return productService.findByCategory(category, 2, priceRange);
                case "filter3":
                    return productService.findByCategory(category, 3, priceRange);
                case "filter4":
                    return productService.findByCategory(category, 4 ,priceRange);
                case "filter5":
                    return productService.findByCategory(category, 5, priceRange);
                case "filter6":
                    return productService.findByCategory(category, 6, priceRange);
                case "filter7":
                    return productService.findByCategory(category, 7, priceRange);
                default:
                    return productService.findByCategory(category, 1, priceRange);
            }
        } else
            return productService.findByCategory(category, 1, 50.0f);
    }

    @GetMapping("{id}")
    public Produkt getById(@PathVariable(name = "id", required = false)Integer id) {
        return productService.getById( id);
    }

    @GetMapping("getPopular")
    public List<Produkt> findPopular() {
        return productService.findPopular();
    }

    @GetMapping("getNew")
    public List<Produkt> findNew() {
        return productService.findNew();
    }
}
