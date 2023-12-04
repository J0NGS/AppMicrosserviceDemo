package com.jongs.br.MsCreditAvaliator.Model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RequestCard {
    private long idCard;
    private String cpf;
    private String adress;
    private BigDecimal limitFree;
}
