package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ProductImage {
    private String image;

    public ProductImage(String image) {
        validate(image);

        this.image = image;
    }

    private void validate(String image) {
        if (image == null) {
            throw new IllegalArgumentException("Image cannot be null");
        }
    }
}
