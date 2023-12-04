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
public class Card {
    private Long id;
    private String name;
    private String flag;
    private BigDecimal limit;
}
