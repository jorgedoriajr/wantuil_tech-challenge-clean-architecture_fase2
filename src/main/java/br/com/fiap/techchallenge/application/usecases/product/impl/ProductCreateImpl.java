package br.com.fiap.techchallenge.application.usecases.product.impl;

import br.com.fiap.techchallenge.application.usecases.product.ProductCreate;
import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import br.com.fiap.techchallenge.domain.entities.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductCreateImpl implements ProductCreate {
    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

}
