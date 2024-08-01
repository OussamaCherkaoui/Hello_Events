package com.hello_event.mapper;

import com.hello_event.dto.TicketDTO;
import com.hello_event.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    @Mapping(source = "user.idUser", target = "user_id")
    @Mapping(source = "event.id", target = "event_id")
    TicketDTO toDTO(Ticket ticket);
    @Mapping(source = "user_id", target = "user.idUser")
    @Mapping(source = "event_id", target = "event.id")
    Ticket toEntity(TicketDTO ticketDTO);
    List<TicketDTO> toDTO(List<Ticket> ticketList);
    List<Ticket> toEntity(List<TicketDTO> ticketDTOList);
}
