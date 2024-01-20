package br.com.fiap.techchallenge.frameworks.configs;

import br.com.fiap.techchallenge.application.usecases.product.CreateProduct;
import br.com.fiap.techchallenge.application.usecases.product.FindProduct;
import br.com.fiap.techchallenge.application.usecases.product.FindProductByCategory;
import br.com.fiap.techchallenge.application.usecases.product.RemoveProduct;
import br.com.fiap.techchallenge.application.gateways.ProductGateway;
import br.com.fiap.techchallenge.application.usecases.product.UpdateProduct;
import br.com.fiap.techchallenge.application.usecases.product.impl.CreateProductImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.FindByProductCategoryImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.FindProductImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.RemoveProductImpl;
import br.com.fiap.techchallenge.application.usecases.product.impl.UpdateProductImpl;
import br.com.fiap.techchallenge.frameworks.web.product.CreateProductWeb;
import br.com.fiap.techchallenge.frameworks.web.product.FindProductByCategoryWeb;
import br.com.fiap.techchallenge.frameworks.web.product.FindProductWeb;
import br.com.fiap.techchallenge.frameworks.web.product.RemoveProductWeb;
import br.com.fiap.techchallenge.frameworks.web.product.UpdateProductWeb;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductRequestToProduct;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductToProductResponse;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.CreateProductControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.FindProductByCategoryControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.FindProductControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.RemoveProductControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.product.impl.UpdateProductControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBean {

    @Bean
    CreateProduct productCreate(final ProductGateway productRepository) {
        return new CreateProductImpl(productRepository);
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
    CreateProductWeb productCreateController(final CreateProduct productCreate,
                                             final ProductRequestToProduct productRequestToProduct,
                                             final ProductToProductResponse productToProductResponse) {
        return new CreateProductControllerImpl(productCreate, productRequestToProduct, productToProductResponse);
    }

    @Bean
    FindProductByCategory productFindByCategory(final ProductGateway productRepository) {
        return new FindByProductCategoryImpl(productRepository);
    }

    @Bean
    FindProductByCategoryWeb productFindByCategoryController(final FindProductByCategory productFindByCategory,
                                                             final ProductToProductResponse productToProductResponse) {
        return new FindProductByCategoryControllerImpl(productFindByCategory, productToProductResponse);
    }

    @Bean
    FindProduct productFind(final ProductGateway productRepository) {
        return new FindProductImpl(productRepository);
    }

    @Bean
    FindProductWeb productFindController(final FindProduct productFind,
                                         final ProductToProductResponse productToProductResponse) {
        return new FindProductControllerImpl(productFind, productToProductResponse);
    }

    @Bean
    RemoveProduct productRemove(final ProductGateway productRepository) {
        return new RemoveProductImpl(productRepository);
    }

    @Bean
    RemoveProductWeb productRemoveController(final RemoveProduct productRemove) {
        return new RemoveProductControllerImpl(productRemove);
    }

    @Bean
    UpdateProduct productUpdate(final ProductGateway productRepository) {
        return new UpdateProductImpl(productRepository);
    }

    @Bean
    UpdateProductWeb productUpdateController(final UpdateProduct productUpdate,
                                             final ProductRequestToProduct productRequestToProduct,
                                             final ProductToProductResponse productToProductResponse) {
        return new UpdateProductControllerImpl(productUpdate, productRequestToProduct, productToProductResponse);
    }
}
