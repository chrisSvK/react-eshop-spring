package com.react_eshop.reacteshop.api.services;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import com.react_eshop.reacteshop.api.dao.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Produkt> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Produkt> findByCategory(Integer category) {
       return productRepository.findByKategoriaId(category);
    }

    @Override
    public List<Produkt> findPopular() {
        return productRepository.findPopular();
    }
}
