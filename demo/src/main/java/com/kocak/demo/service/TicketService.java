package com.kocak.demo.service;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;

public interface TicketService {

    public void sellTicket(TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO);

    public void cancelTicket(TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO);

}
