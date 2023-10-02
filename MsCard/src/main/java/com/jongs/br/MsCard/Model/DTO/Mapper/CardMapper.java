package com.jongs.br.MsCard.Model.DTO.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jongs.br.MsCard.Model.Card;
import com.jongs.br.MsCard.Model.DTO.CardSaveRequest;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE  = Mappers.getMapper(CardMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "flag", target = "flag")
    @Mapping(source = "limit", target = "limit")
    @Mapping(source = "income", target = "income")
    Card cardSaveRequestoToCard(CardSaveRequest request);
}
