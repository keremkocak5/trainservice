package com.kocak.demo.mapper;


import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsPassengersResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TicketMapperTest {

    @Test
    public void mapTicketServiceSellTicketRequestDtoToTicket_shouldReturnTicket()
    {
        TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO = TicketServiceSellTicketRequestDTO.builder().ticketNumber(TICKET_NUMBER).passengerName(PASSENGER_NAME).price(PRICE).trainNumber(TRAIN_NUMBER).build();
        Ticket ticket = TicketMapper.mapTicketServiceSellTicketRequestDtoToTicket(ticketServiceSellTicketRequestDTO);
        assertThat(ticket).isNotNull();
        assertThat(ticket.getId()).isEqualTo(INITIAL_ID);
        assertThat(ticket.getPassengerName()).isEqualTo(PASSENGER_NAME);
        assertThat(ticket.getPrice()).isEqualTo(PRICE);
        assertThat(ticket.getTicketNumber()).isEqualTo(TICKET_NUMBER);
        assertThat(ticket.getTicketStatus()).isEqualTo(TICKET_STATUS);
        assertThat(ticket.getTrainId()).isEqualTo(TRAIN_NUMBER);
    }

    public static final int INITIAL_ID = 0;
    public static final int TRAIN_NUMBER = 1;
    public static final String PASSENGER_NAME = "Bill Gates";
    public static final int PRICE = 10;
    public static final TicketStatus TICKET_STATUS = TicketStatus.VALID;
    public static final int TICKET_NUMBER = 20;
}
