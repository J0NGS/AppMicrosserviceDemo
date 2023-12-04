package com.jongs.br.MsCreditAvaliator.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AvaliationData {
    private String cpf;
    private Long income;
}
