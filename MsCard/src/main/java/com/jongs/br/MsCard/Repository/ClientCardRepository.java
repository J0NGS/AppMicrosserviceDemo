package com.jongs.br.MsCard.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jongs.br.MsCard.Model.ClientCard;
import java.util.List;


public interface ClientCardRepository extends JpaRepository <ClientCard, Long>{
    Optional<List<ClientCard>> findByCpf(String cpf);
}
