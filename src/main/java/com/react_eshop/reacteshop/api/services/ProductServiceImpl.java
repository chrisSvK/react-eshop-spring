package com.react_eshop.reacteshop.api.services;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import com.react_eshop.reacteshop.api.dao.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Produkt> findAll(Integer filter) {
        if (filter != null)
            switch (filter) {
                case 2:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
                case 3:
                    return productRepository.findAllValueASC();
                case 4:
                    return productRepository.findAllValueDESC();
                case 5:
                    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "datumPridania"));
                case 6:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "datumPridania"));
                case 7:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "pocetObjednani"));
                default:
                    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
            }
        else
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Produkt> findByCategory(Integer category, Integer filter) {
        if (filter != null)
            switch (filter) {
                case 2:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "name"));
                case 3:
                    return productRepository.findByKategoriaIdValueASC(category);
                case 4:
                    return productRepository.findByKategoriaIdValueDESC(category);
                case 5:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "datumPridania"));
                case 6:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "datumPridania"));
                case 7:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "pocetObjednani"));
                default:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "name"));
            }
        else
            return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Produkt> findPopular() {
        return productRepository.findPopular();
    }
}
