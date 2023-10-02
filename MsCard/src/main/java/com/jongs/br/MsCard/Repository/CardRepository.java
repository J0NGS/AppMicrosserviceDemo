package com.jongs.br.MsCard.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.jongs.br.MsCard.Model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{
    Optional<List<Card>> findByIncomeLessThanEqual(BigDecimal incomeBigDecimal);
}
