package com.jongs.br.MsCard.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jongs.br.MsCard.Model.ClientCard;
import com.jongs.br.MsCard.Model.ClientCardResponse;
import com.jongs.br.MsCard.Repository.ClientCardRepository;

@Service
public class ClientCardService {
    private ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository){
        this.repository = repository;
    }

    public ResponseEntity<List<ClientCardResponse>> getByCpf(String cpf){
        if(repository.findByCpf(cpf).isPresent())
            return ResponseEntity.ok(repository.findByCpf(cpf).get().stream().map(ClientCardResponse::fromModel).collect(Collectors.toList()));
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
