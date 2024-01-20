package br.com.fiap.techchallenge.frameworks.db.impl;

import java.util.List;
import java.util.UUID;

import br.com.fiap.techchallenge.application.gateways.ProductGateway;
import br.com.fiap.techchallenge.domain.entities.Product;
import br.com.fiap.techchallenge.frameworks.db.converters.ProductEntityToProduct;
import br.com.fiap.techchallenge.frameworks.db.converters.ProductToProductEntity;
import br.com.fiap.techchallenge.frameworks.db.repositories.SpringDataProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductGateway {

    private final SpringDataProductRepository springDataProductRepository;

    private final ProductEntityToProduct productEntityToProduct;

    private final ProductToProductEntity productToProductEntity;

    @Override
    public List<Product> find() {
        return springDataProductRepository
                .findAll()
                .stream()
                .map(productEntityToProduct::convert)
                .toList();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return springDataProductRepository.findByCategory(category)
                .stream()
                .map(productEntityToProduct::convert)
                .toList();
    }

    @Override
    public Product create(Product product) {
        var productEntity = productToProductEntity.convert(product);
        productEntity = springDataProductRepository.save(productEntity);

        return productEntityToProduct.convert(productEntity);
    }

    @Override
    public Product update(String id, Product product) {
        var productEntity = springDataProductRepository
                .findById(UUID.fromString(product.getId())).orElseThrow();

        productEntity.setName(product.getName().getName());
        productEntity.setCategory(product.getCategory().getCategory().name());
        productEntity.setPrice(product.getPrice().getPrice());
        productEntity.setDescription(product.getDescription().getDescription());
        productEntity.setImage(product.getImage().getImage());
        productEntity = springDataProductRepository.save(productEntity);

        return productEntityToProduct.convert(productEntity);
    }

    @Override
    public void remove(String id) {
        springDataProductRepository.deleteById(UUID.fromString(id));
    }
}
