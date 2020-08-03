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

    public List<Produkt> findAll(Integer filter, Float priceRange) {
        if (filter != null)
            switch (filter) {
                case 2:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"), priceRange);
                case 3:
                    return productRepository.findAllValueASC(priceRange);
                case 4:
                    return productRepository.findAllValueDESC(priceRange);
                case 5:
                    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "datumPridania"), priceRange);
                case 6:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "datumPridania"), priceRange);
                case 7:
                    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "pocetObjednani"), priceRange);
                default:
                    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"), priceRange);
            }
        else
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Produkt> findByCategory(Integer category, Integer filter, Float priceRange) {
        if (filter != null)
            switch (filter) {
                case 2:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "name"), priceRange);
                case 3:
                    return productRepository.findByKategoriaIdValueASC(category, priceRange);
                case 4:
                    return productRepository.findByKategoriaIdValueDESC(category, priceRange);
                case 5:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "datumPridania"), priceRange);
                case 6:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "datumPridania"), priceRange);
                case 7:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.DESC, "pocetObjednani"), priceRange);
                default:
                    return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "name"), priceRange);
            }
        else
            return productRepository.findByKategoriaId(category, Sort.by(Sort.Direction.ASC, "name"), 50.0f);
    }

    @Override
    public List<Produkt> findCaj(Integer filter, Float priceRange) {
        if (filter != null)
            switch (filter) {
                case 2:
                    return productRepository.findByCaj( Sort.by(Sort.Direction.DESC, "name"), priceRange);
                case 3:
                    return productRepository.findByCajASC( priceRange);
                case 4:
                    //return productRepository.findByCajDESC( priceRange);
                case 5:
                    return productRepository.findByCaj( Sort.by(Sort.Direction.ASC, "datumPridania"), priceRange);
                case 6:
                    return productRepository.findByCaj( Sort.by(Sort.Direction.DESC, "datumPridania"), priceRange);
                case 7:
                    return productRepository.findByCaj( Sort.by(Sort.Direction.DESC, "pocetObjednani"), priceRange);
                default:
                    return productRepository.findByCaj( Sort.by(Sort.Direction.ASC, "name"), priceRange);
            }
        else
            return productRepository.findByCaj( Sort.by(Sort.Direction.ASC, "name"), 50.0f);
    }

    @Override
    public List<Produkt> findPopular() {
        return productRepository.findPopular();
    }

    @Override
    public List<Produkt> findNew() {
        return productRepository.findNew();
    }

    @Override
    public  Produkt getById(Integer id){
        return productRepository.findByproduktId(id);
    };
}
