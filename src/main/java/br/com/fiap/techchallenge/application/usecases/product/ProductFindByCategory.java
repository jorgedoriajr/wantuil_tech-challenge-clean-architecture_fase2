package br.com.fiap.techchallenge.application.usecases.product;

import java.util.List;

import br.com.fiap.techchallenge.domain.entities.Product;

public interface ProductFindByCategory {

    List<Product> findByCategory(String category);
}
