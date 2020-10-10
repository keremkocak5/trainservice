package com.kocak.demo.mapper;

import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.model.Ticket;

public class TicketMapper {

    public static Ticket mapTicketServiceSellTicketRequestDtoToTicket(TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO) {
        return Ticket.builder().price(ticketServiceSellTicketRequestDTO.getPrice()).passengerName(ticketServiceSellTicketRequestDTO.getPassengerName()).ticketNumber(ticketServiceSellTicketRequestDTO.getTicketNumber()).trainId(ticketServiceSellTicketRequestDTO.getTrainNumber()).ticketStatus(TicketStatus.VALID).build();
    }
}
