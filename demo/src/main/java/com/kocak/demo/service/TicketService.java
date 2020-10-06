package com.kocak.demo.service;

import com.kocak.demo.domain.request.*;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;

public interface TicketService {

    public void sellTicket(TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO);

    public void cancelTicket(TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO);

}
