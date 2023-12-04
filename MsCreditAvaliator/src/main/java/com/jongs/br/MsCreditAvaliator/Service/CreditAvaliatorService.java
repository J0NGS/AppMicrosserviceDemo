package com.jongs.br.MsCreditAvaliator.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jongs.br.MsCreditAvaliator.Infra.Mqueue.CardEmissionRequestPublisher;
import com.jongs.br.MsCreditAvaliator.Infra.clients.CardResourceClient;
import com.jongs.br.MsCreditAvaliator.Infra.clients.ClientResourceClient;
import com.jongs.br.MsCreditAvaliator.Model.AprovedCards;
import com.jongs.br.MsCreditAvaliator.Model.AvaliationClientReturn;
import com.jongs.br.MsCreditAvaliator.Model.Card;
import com.jongs.br.MsCreditAvaliator.Model.ClientData;
import com.jongs.br.MsCreditAvaliator.Model.ClientSituation;
import com.jongs.br.MsCreditAvaliator.Model.ProtocolCardRequest;
import com.jongs.br.MsCreditAvaliator.Model.RequestCard;

import feign.FeignException.FeignClientException;
@Service 
public class CreditAvaliatorService {
     private final ClientResourceClient clients;
     private final CardResourceClient cards;
     private final CardEmissionRequestPublisher publisher;

     @Autowired
     public CreditAvaliatorService(ClientResourceClient clients, CardResourceClient cards, CardEmissionRequestPublisher publisher){
          this.clients = clients;
          this.cards = cards;
          this.publisher = publisher;
     }

     public ResponseEntity<ClientSituation> getClientStatus(String cpf){
          try {
               ClientSituation client = new ClientSituation(clients.getClient(cpf).getBody(), cards.getCardByClient(cpf).getBody());
               return ResponseEntity.ok(client);
          } catch (FeignClientException e) {
               int status = e.status();
               if(HttpStatus.NOT_FOUND.value() == status){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found with cpf-> " + cpf);
               }
               throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
          }
     }

     public ResponseEntity<AvaliationClientReturn> getAvaliation(String cpf, Long income){
          try {
               List<Card> listCards = cards.getCardByIncome(income).getBody();
               ClientData client = clients.getClient(cpf).getBody();
               AvaliationClientReturn clientReturn = new AvaliationClientReturn(listCards.stream().map(card->{
                    BigDecimal limitBasic = card.getLimit();
                    BigDecimal ageClient = BigDecimal.valueOf(client.getAge());
                    
                    var fator = ageClient.divide(BigDecimal.valueOf(10));     
                    BigDecimal limitAproved = fator.multiply(limitBasic);

                    AprovedCards aproved = new AprovedCards();
                    aproved.setCard(card.getName());
                    aproved.setFlag(card.getFlag());
                    aproved.setLimitAproved(limitAproved);
                    return aproved;
               }).collect(Collectors.toList()));
               return ResponseEntity.ok(clientReturn);
          } catch (FeignClientException e) {
               int status = e.status();
               if(HttpStatus.NOT_FOUND.value() == status){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found with cpf-> " + cpf);
               }
               throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
          }   
     }


     public ProtocolCardRequest requestCard(RequestCard request){
          try {
               publisher.requestCard(request);
               var protocol = UUID.randomUUID().toString();
               return new ProtocolCardRequest(protocol);
          } catch (Exception e) {
               e.getMessage();
               return null;}
     }

}
