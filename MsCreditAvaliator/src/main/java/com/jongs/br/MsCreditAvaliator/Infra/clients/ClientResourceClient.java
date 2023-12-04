package com.jongs.br.MsCreditAvaliator.Infra.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jongs.br.MsCreditAvaliator.Model.ClientData;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientResourceClient {
    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> getClient(@RequestParam("cpf") String cpf);

    
}
