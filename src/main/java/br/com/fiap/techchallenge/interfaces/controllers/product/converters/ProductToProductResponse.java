package br.com.fiap.techchallenge.interfaces.controllers.product.converters;


import br.com.fiap.techchallenge.domain.entities.Product;
import br.com.fiap.techchallenge.interfaces.controllers.product.responses.ProductResponse;

public class ProductToProductResponse {

    public ProductResponse convert(final Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName().getName())
                .category(product.getCategory().getCategory().name())
                .price(product.getPrice().getPrice())
                .description(product.getDescription().getDescription())
                .image(product.getImage().getImage())
                .build();
    }
}
