package br.com.fiap.techchallenge.application.usecases.product.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.product.ProductRemove;
import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductRemoveImpl implements ProductRemove {
    private final ProductRepository productRepository;

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }
}
