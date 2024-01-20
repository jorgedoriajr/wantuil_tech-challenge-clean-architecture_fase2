package br.com.fiap.techchallenge.infrastructure.configs;

import br.com.fiap.techchallenge.application.usecases.product.ProductCreate;
import br.com.fiap.techchallenge.application.usecases.product.ProductFind;
import br.com.fiap.techchallenge.application.usecases.product.ProductFindByCategory;
import br.com.fiap.techchallenge.application.usecases.product.ProductRemove;
import br.com.fiap.techchallenge.application.usecases.product.ProductRepository;
import br.com.fiap.techchallenge.application.usecases.product.ProductUpdate;
import br.com.fiap.techchallenge.application.usecases.product.impl.ProductCreateImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.ProductFindByCategoryImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.ProductFindImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.ProductRemoveImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.ProductUpdateImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductCreateController;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductFindByCategoryController;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductFindController;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductRemoveController;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductUpdateController;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductRequestToProduct;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductToProductResponse;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.ProductCreateControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.ProductFindByCategoryControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.ProductFindControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.ProductRemoveControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.ProductUpdateControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBean {

    @Bean
    ProductCreate productCreate(final ProductRepository productRepository) {
        return new ProductCreateImpl(productRepository);
    }

    @Bean
    ProductRequestToProduct productRequestToProduct() {
        return new ProductRequestToProduct();
    }

    @Bean
    ProductToProductResponse productToProductResponse() {
        return new ProductToProductResponse();
    }

    @Bean
    ProductCreateController productCreateController(final ProductCreate productCreate,
                                                    final ProductRequestToProduct productRequestToProduct,
                                                    final ProductToProductResponse productToProductResponse) {
        return new ProductCreateControllerImpl(productCreate, productRequestToProduct, productToProductResponse);
    }

    @Bean
    ProductFindByCategory productFindByCategory(final ProductRepository productRepository) {
        return new ProductFindByCategoryImpl(productRepository);
    }

    @Bean
    ProductFindByCategoryController productFindByCategoryController(final ProductFindByCategory productFindByCategory,
                                                                    final ProductToProductResponse productToProductResponse) {
        return new ProductFindByCategoryControllerImpl(productFindByCategory, productToProductResponse);
    }

    @Bean
    ProductFind productFind(final ProductRepository productRepository) {
        return new ProductFindImpl(productRepository);
    }

    @Bean
    ProductFindController productFindController(final ProductFind productFind,
                                                final ProductToProductResponse productToProductResponse) {
        return new ProductFindControllerImpl(productFind, productToProductResponse);
    }

    @Bean
    ProductRemove productRemove(final ProductRepository productRepository) {
        return new ProductRemoveImpl(productRepository);
    }

    @Bean
    ProductRemoveController productRemoveController(final ProductRemove productRemove) {
        return new ProductRemoveControllerImpl(productRemove);
    }

    @Bean
    ProductUpdate productUpdate(final ProductRepository productRepository) {
        return new ProductUpdateImpl(productRepository);
    }

    @Bean
    ProductUpdateController productUpdateController(final ProductUpdate productUpdate,
                                                    final ProductRequestToProduct productRequestToProduct,
                                                    final ProductToProductResponse productToProductResponse) {
        return new ProductUpdateControllerImpl(productUpdate, productRequestToProduct, productToProductResponse);
    }
}
