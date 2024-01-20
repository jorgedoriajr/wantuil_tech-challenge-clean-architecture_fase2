package br.com.fiap.techchallenge.application.usecases.product.impl;

import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import br.com.fiap.techchallenge.application.usecases.product.ProductUpdate;
import br.com.fiap.techchallenge.domain.entities.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductUpdateImpl implements ProductUpdate {
    private final ProductRepository productRepository;

    @Override
    public Product update(String id, Product product) {
        return productRepository.update(id, product);
    }

}
