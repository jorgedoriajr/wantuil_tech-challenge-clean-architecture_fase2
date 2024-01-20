package br.com.fiap.techchallenge.application.usecases.product.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.product.ProductFindByCategory;
import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import br.com.fiap.techchallenge.domain.entities.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFindByCategoryImpl implements ProductFindByCategory {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

}
