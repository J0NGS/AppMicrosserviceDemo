package com.jongs.br.MsClientes.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;
}
