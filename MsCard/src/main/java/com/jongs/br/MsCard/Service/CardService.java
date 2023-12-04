package com.jongs.br.MsCard.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.jongs.br.MsCard.Model.Card;
import com.jongs.br.MsCard.Model.DTO.CardSaveRequest;
import com.jongs.br.MsCard.Repository.CardRepository;
@Service
public class CardService {
    private final CardRepository repository;

    @Autowired
    public CardService(CardRepository repository){
        this.repository = repository;
    }

    @Transactional
    public ResponseEntity<Card> save (CardSaveRequest request){
        Card card = request.toModel();
        return ResponseEntity.ok(repository.save(card));
    }

    public ResponseEntity<List<Card>> getCardsByIncomeLessThanEqual(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        if(repository.findByIncomeLessThanEqual(incomeBigDecimal).isPresent())
            return ResponseEntity.ok(repository.findByIncomeLessThanEqual(incomeBigDecimal).get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
