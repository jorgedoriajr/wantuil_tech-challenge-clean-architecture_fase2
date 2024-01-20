package br.com.fiap.techchallenge.interfaces.controllers.product.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class ProductRequest {
    private String id;
    private String name;
    private String category;
    private Double price;
    private String description;
    private String image;
}
