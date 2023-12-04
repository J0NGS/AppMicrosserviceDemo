package com.jongs.br.MsCreditAvaliator.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.card-emission}")
    private String queueName;

    @Bean
    public Queue queueCardEmission(){
        return new Queue(queueName, true);
    }
}
