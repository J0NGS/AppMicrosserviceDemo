package com.jongs.br.MsClientes.Model.DTO.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jongs.br.MsClientes.Model.Client;
import com.jongs.br.MsClientes.Model.DTO.ClientSaveRequest;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "cpf",target = "cpf")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "age",target = "age")
    ClientSaveRequest clientToClientSaveRequest(Client client);

    @Mapping(source = "cpf",target = "cpf")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "age",target = "age")
    Client clientSaveRequestToClient(ClientSaveRequest client);
}