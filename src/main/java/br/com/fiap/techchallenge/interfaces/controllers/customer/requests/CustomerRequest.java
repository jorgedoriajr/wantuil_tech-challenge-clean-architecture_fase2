package br.com.fiap.techchallenge.interfaces.controllers.customer.requests;

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
public class CustomerRequest {
    private String id;
    private String cpf;
    private String name;
    private String email;
}
