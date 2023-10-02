package com.jongs.br.MsCard.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Card {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    
    @Column(name = "card_limit")
    private BigDecimal limit;
    
    private BigDecimal income;

    public enum CardFlag{
        MASTERCARD, VISA
    }

    public Card(String name, CardFlag flag, BigDecimal limit, BigDecimal income) {
        this.name = name;
        this.flag = flag;
        this.limit = limit;
        this.income = income;
    }
}
