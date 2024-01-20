package br.com.fiap.techchallenge.infrastructure.persistence.converters;

import java.util.Objects;
import java.util.UUID;

import br.com.fiap.techchallenge.domain.entities.Product;
import br.com.fiap.techchallenge.infrastructure.persistence.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductEntity {

    public ProductEntity convert(Product product) {
        return ProductEntity
                .builder()
                .id(Objects.nonNull(product.getId()) ? UUID.fromString(product.getId()) : null)
                .name(product.getName().getName())
                .category(product.getCategory().getCategory().name())
                .price(product.getPrice().getPrice())
                .description(product.getDescription().getDescription())
                .image(product.getImage().getImage())
                .build();
    }
}
