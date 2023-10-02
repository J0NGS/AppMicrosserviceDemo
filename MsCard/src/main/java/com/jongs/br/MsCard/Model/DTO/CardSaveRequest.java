package com.jongs.br.MsCard.Model.DTO;

import java.math.BigDecimal;

import com.jongs.br.MsCard.Model.Card;
import com.jongs.br.MsCard.Model.Card.CardFlag;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CardSaveRequest {
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal limit;    

    public Card toModel(){
        Card card = new Card(this.name, this.flag, this.limit, this.income);
        return card;
    }
}
