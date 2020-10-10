package com.kocak.demo.service.impl;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.exception.EntityNotFoundException;
import com.kocak.demo.mapper.TicketMapper;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.repository.TicketRepository;
import com.kocak.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    @Transactional
    public void sellTicket(TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO) {
        ticketRepository.save(TicketMapper.mapTicketServiceSellTicketRequestDtoToTicket(ticketServiceSellTicketRequestDTO));
    }

    @Override
    @Transactional
    public void cancelTicket(TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketServiceCancelTicketRequestDTO.getTicketId());
        if (ticket.isPresent()) {
            ticket.get().setTicketStatus(TicketStatus.CANCELLED);
            ticketRepository.save(ticket.get());
        } else {
            throw new EntityNotFoundException();
        }
    }
}
