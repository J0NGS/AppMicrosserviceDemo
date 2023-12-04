package com.jongs.br.MsCard.Messaging.Mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jongs.br.MsCard.Model.Card;
import com.jongs.br.MsCard.Model.ClientCard;
import com.jongs.br.MsCard.Model.RequestCard;
import com.jongs.br.MsCard.Repository.CardRepository;
import com.jongs.br.MsCard.Repository.ClientCardRepository;

@Component
public class CardEmissionSub {

    private final CardRepository repository;
    private final ClientCardRepository clientCardRepository;

    @Autowired
    public CardEmissionSub(CardRepository repository, ClientCardRepository clientCardRepository){
        this.repository = repository;
        this.clientCardRepository = clientCardRepository;
    }

    @RabbitListener(queues = "${mq.queues.card-emission}")
    public void getEmissionRequest(@Payload String payload){
        try {
            var mapper = new ObjectMapper();
            RequestCard request = mapper.readValue(payload, RequestCard.class);
            Card card = repository.findById(request.getIdCard()).orElseThrow();

            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(request.getCpf());
            clientCard.setLimit(request.getLimitFree());


            clientCardRepository.save(clientCard);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }
    }
}
