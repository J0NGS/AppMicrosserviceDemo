package com.jongs.br.MsClientes.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jongs.br.MsClientes.Model.Client;
import com.jongs.br.MsClientes.Model.DTO.ClientSaveRequest;
import com.jongs.br.MsClientes.Model.DTO.Mappers.ClientMapper;
import com.jongs.br.MsClientes.Service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<URI> save(@RequestBody ClientSaveRequest request){
        Client client = ClientMapper.INSTANCE.clientSaveRequestToClient(request);
        service.save(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf{cpf}").buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.ok(uri);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Client> getClient(@RequestParam("cpf") String cpf){
        return service.getByCPF(cpf);
    }
}
