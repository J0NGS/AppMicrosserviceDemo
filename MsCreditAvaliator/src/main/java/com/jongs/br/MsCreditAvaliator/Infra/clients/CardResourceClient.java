package com.jongs.br.MsCreditAvaliator.Infra.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jongs.br.MsCreditAvaliator.Model.Card;
import com.jongs.br.MsCreditAvaliator.Model.CardClient;

@FeignClient(value = "mscards", path = "/card" )
public interface CardResourceClient {
    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardClient>> getCardByClient(@RequestParam("cpf") String cpf);


    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income);
}
