package br.com.fiap.techchallenge.interfaces.controllers.product.converters;

import br.com.fiap.techchallenge.domain.entities.Product;
import br.com.fiap.techchallenge.domain.vos.ProductCategory;
import br.com.fiap.techchallenge.domain.vos.ProductDescription;
import br.com.fiap.techchallenge.domain.vos.ProductImage;
import br.com.fiap.techchallenge.domain.vos.ProductName;
import br.com.fiap.techchallenge.domain.vos.ProductPrice;
import br.com.fiap.techchallenge.interfaces.controllers.product.requests.ProductRequest;

public class ProductRequestToProduct {

    public Product convert(ProductRequest productRequests) {
        return Product.builder()
                .id(productRequests.getId())
                .name(new ProductName(productRequests.getName()))
                .category(new ProductCategory(productRequests.getCategory()))
                .price(new ProductPrice(productRequests.getPrice()))
                .description(new ProductDescription(productRequests.getDescription()))
                .image(new ProductImage(productRequests.getImage()))
                .build();

    }
}
