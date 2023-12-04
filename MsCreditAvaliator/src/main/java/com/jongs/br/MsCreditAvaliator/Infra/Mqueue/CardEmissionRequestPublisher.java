package com.jongs.br.MsCreditAvaliator.Infra.Mqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jongs.br.MsCreditAvaliator.Model.RequestCard;

@Component
public class CardEmissionRequestPublisher {
    private final RabbitTemplate template;
    private final Queue queue; 

    @Autowired
    public CardEmissionRequestPublisher(RabbitTemplate template, Queue queue){
        this.template = template;
        this.queue = queue;
    }


    public void requestCard(RequestCard request) throws JsonProcessingException{
        var json = convertToJson(request);
        template.convertAndSend(queue.getName(), json);
    }

    private String convertToJson(RequestCard request) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(request);
        return json;
    }
}
