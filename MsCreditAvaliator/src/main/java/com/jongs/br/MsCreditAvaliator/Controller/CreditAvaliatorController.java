package com.jongs.br.MsCreditAvaliator.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jongs.br.MsCreditAvaliator.Model.AvaliationClientReturn;
import com.jongs.br.MsCreditAvaliator.Model.AvaliationData;
import com.jongs.br.MsCreditAvaliator.Model.RequestCard;
import com.jongs.br.MsCreditAvaliator.Service.CreditAvaliatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("credit-avaliator")
public class CreditAvaliatorController {
    CreditAvaliatorService service;

    @Autowired
    public CreditAvaliatorController(CreditAvaliatorService service){
        this.service = service;
    }

    @GetMapping(value="client-situation", params = "cpf")
    public ResponseEntity getMethodName(@RequestParam("cpf") String cpf) {
        return service.getClientStatus(cpf);
    }
    
    @PostMapping
    public ResponseEntity<AvaliationClientReturn> getAvaliation(@RequestBody AvaliationData data){
        return service.getAvaliation(data.getCpf(), data.getIncome());
    }

    @PostMapping("request-card")
    public ResponseEntity requestCard(@RequestBody RequestCard request){
        try {
            return ResponseEntity.ok(service.requestCard(request));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
