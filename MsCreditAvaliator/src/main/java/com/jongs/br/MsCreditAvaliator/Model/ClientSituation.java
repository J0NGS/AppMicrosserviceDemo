package com.jongs.br.MsCreditAvaliator.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientSituation {
    private ClientData  client;
    private List<CardClient> cards;


    public ClientSituation(ClientData client){
        this.client = client;
        this.cards = null;
    }
}
