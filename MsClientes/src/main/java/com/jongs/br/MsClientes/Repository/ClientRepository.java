package com.jongs.br.MsClientes.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jongs.br.MsClientes.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

    Optional<Client> findBycpf(String cpf);
    
}
