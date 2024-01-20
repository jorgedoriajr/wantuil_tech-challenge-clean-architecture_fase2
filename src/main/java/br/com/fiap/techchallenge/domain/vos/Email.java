package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Email {
    private final String email;

    public Email(String email) {
        validate(email);

        this.email = email;
    }

    private void validate(String email) {
        if (email == null || email.isEmpty()) {
            return;
        }

        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email must be in the format");
        }
    }
}
