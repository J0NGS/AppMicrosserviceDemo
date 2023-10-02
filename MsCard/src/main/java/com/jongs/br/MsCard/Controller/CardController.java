package com.jongs.br.MsCard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jongs.br.MsCard.Model.Card;
import com.jongs.br.MsCard.Model.DTO.CardSaveRequest;
import com.jongs.br.MsCard.Model.DTO.Mapper.CardMapper;
import com.jongs.br.MsCard.Service.CardService;
import com.jongs.br.MsCard.Service.ClientCardService;

@RestController
@RequestMapping("card")
public class CardController {
    private CardService service;
    private ClientCardService clientCardService;

    @Autowired
    public CardController(CardService service, ClientCardService clientCardService){
        this.service = service;
        this.clientCardService = clientCardService;
    }

    @PostMapping
    public ResponseEntity registerCard(@RequestBody CardSaveRequest request){
        return service.save(request);
    }

    @GetMapping(params = "income")
    public ResponseEntity getCardByIncome(@RequestParam("income") Long income){
        return service.getCardsByIncomeLessThanEqual(income); 
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getCardByClient(@RequestParam("cpf") String cpf){
        return clientCardService.getByCpf(cpf);
    }
}
