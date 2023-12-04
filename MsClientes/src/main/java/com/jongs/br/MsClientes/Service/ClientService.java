package com.jongs.br.MsClientes.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jongs.br.MsClientes.Repository.ClientRepository;
import com.jongs.br.MsClientes.Model.Client;
import jakarta.transaction.Transactional;

@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public ResponseEntity<Client> getByCPF(String cpf){
        Optional<Client> client = repository.findBycpf(cpf);
        if(client.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with cpf[ "+ cpf +" ] not found");
        else
            return ResponseEntity.ok(client.get());
    }
}
