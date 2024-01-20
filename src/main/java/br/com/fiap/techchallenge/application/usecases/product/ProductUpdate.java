package br.com.fiap.techchallenge.application.usecases.product;

import br.com.fiap.techchallenge.domain.entities.Product;

public interface ProductUpdate {
    Product update(String id, Product product);
}
