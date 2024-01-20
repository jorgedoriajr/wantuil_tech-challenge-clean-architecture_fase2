package br.com.fiap.techchallenge.interfaces.controllers.product.responses;

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
public class ProductResponse {
    private String id;
    private String name;
    private String category;
    private Double price;
    private String description;
    private String image;
}
