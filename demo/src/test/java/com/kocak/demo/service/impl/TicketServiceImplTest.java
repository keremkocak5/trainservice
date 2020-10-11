package com.kocak.demo.service.impl;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.exception.EntityNotFoundException;
import com.kocak.demo.mapper.TicketMapper;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.repository.TicketRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TicketServiceImplTest {

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sellTicket_shouldPersistOnlyOnce()
    {
        TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO = TicketServiceSellTicketRequestDTO.builder().trainNumber(TRAIN_NUMBER).price(PRICE).passengerName(PASSENGER_NAME).ticketNumber(TICKET_NUMBER).build();
        ticketService.sellTicket(ticketServiceSellTicketRequestDTO);
        verify(ticketRepository, times(1)).save(Mockito.any(Ticket.class));
    }

    @Test
    public void cancelTicket_shouldPersistOnlyOnce()
    {
        TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO = new TicketServiceCancelTicketRequestDTO();
        Ticket ticket = new Ticket();
        Mockito.when(ticketRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(ticket));
        ticketService.cancelTicket(ticketServiceCancelTicketRequestDTO);
        verify(ticketRepository, times(1)).save(Mockito.any(Ticket.class));
    }

    @Test
    public void cancelTicket_shouldThrowExceptionWhenTicketNotFound()
    {
        TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO = new TicketServiceCancelTicketRequestDTO();
        Mockito.when(ticketRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            ticketService.cancelTicket(ticketServiceCancelTicketRequestDTO);});
    }

    public static final int INITIAL_ID = 0;
    public static final int ID = 100;
    public static final int TRAIN_NUMBER = 1;
    public static final LocalDate DEPARTURE_DATE = LocalDate.now();
    public static final String DRIVER_NAME = "Kerem Kocak";
    public static final String PASSENGER_NAME = "Bill Gates";
    public static final int INITIAL_CAPACITY = 10;
    public static final int PRICE = 10;
    public static final TicketStatus TICKET_STATUS = TicketStatus.VALID;
    public static final int TICKET_NUMBER = 20;

}
