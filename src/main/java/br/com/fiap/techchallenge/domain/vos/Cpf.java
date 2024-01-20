package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Cpf {
    private final String cpf;

    public Cpf(String cpf) {
        validate(cpf);

        this.cpf = cpf;
    }

    private void validate(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return;
        }

        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF must be in the format XXX.XXX.XXX-XX");
        }
    }
}
