package com.jongs.br.MsCreditAvaliator.Model;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AprovedCards {
    private String card;
    private String flag;
    private BigDecimal limitAproved;
}
