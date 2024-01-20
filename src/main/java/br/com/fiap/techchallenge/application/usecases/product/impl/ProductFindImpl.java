package br.com.fiap.techchallenge.application.usecases.product.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.product.ProductFind;
import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import br.com.fiap.techchallenge.domain.entities.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFindImpl implements ProductFind {
    private final ProductRepository productRepository;

    @Override
    public List<Product> find() {
        return productRepository.find();
    }

}
