package com.jongs.br.MsCard.Model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientCardResponse {
    private String name;
    private String flag;
    private BigDecimal limit;

    public static ClientCardResponse fromModel(ClientCard card){
        return new ClientCardResponse(card.getCard().getName(), card.getCard().getFlag().toString(), card.getLimit());
    }
}
