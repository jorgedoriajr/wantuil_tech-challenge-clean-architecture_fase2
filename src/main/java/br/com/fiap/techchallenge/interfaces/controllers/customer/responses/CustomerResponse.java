package br.com.fiap.techchallenge.interfaces.controllers.customer.responses;

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
public class CustomerResponse {
    private String id;
    private String cpf;
    private String name;
    private String email;
}
