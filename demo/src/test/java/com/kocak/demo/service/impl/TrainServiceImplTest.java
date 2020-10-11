package com.kocak.demo.service.impl;

import com.kocak.demo.domain.request.*;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.exception.EntityNotFoundException;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.repository.TicketRepository;
import com.kocak.demo.repository.TrainRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TrainServiceImplTest {

    @InjectMocks
    private TrainServiceImpl trainService;

    @Mock
    private TrainRepository trainRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addRide_shouldPersistOnlyOnce()
    {
        TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO =  new TrainServiceAddRideRequestDTO();
        trainService.addRide(trainServiceAddRideRequestDTO);
        verify(trainRepository, times(1)).save(Mockito.any(TrainSchedule.class));
    }

    @Test
    public void getRide_shouldReturnTrainServiceGetRideResponseDTO()
    {
        TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO = new TrainServiceGetRideRequestDTO();
        TrainSchedule trainSchedule = TrainSchedule.builder().trainNumber(10).initialCapacity(INITIAL_CAPACITY).driverName(DRIVER_NAME).departureDate(DEPARTURE_DATE).build();
        Mockito.when(trainRepository.findByTrainNumber(Mockito.anyInt())).thenReturn(Optional.ofNullable(trainSchedule));
        TrainServiceGetRideResponseDTO trainServiceGetRideResponseDTO = trainService.getRide(trainServiceGetRideRequestDTO);
        assertThat(trainServiceGetRideResponseDTO).isNotNull();
        assertThat(trainServiceGetRideResponseDTO.getDepartureDate()).isEqualTo(DEPARTURE_DATE);
        assertThat(trainServiceGetRideResponseDTO.getId()).isEqualTo(INITIAL_ID);
    }

    @Test
    public void getRide_shouldThrowExceptionWhenRideNotFound()
    {
        TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO = new TrainServiceGetRideRequestDTO();
        Mockito.when(trainRepository.findByTrainNumber(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            trainService.getRide(trainServiceGetRideRequestDTO);});
    }

    @Test
    public void getRideDetails_shouldReturnTrainServiceGetRideResponseDTO()
    {
        TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO = new TrainServiceGetRideDetailsRequestDTO();
        TrainSchedule trainSchedule = TrainSchedule.builder().trainNumber(10).initialCapacity(INITIAL_CAPACITY).driverName(DRIVER_NAME).departureDate(DEPARTURE_DATE).build();
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = Ticket.builder().ticketStatus(TICKET_STATUS).ticketNumber(TICKET_NUMBER).passengerName(PASSENGER_NAME).price(PRICE).trainId(TRAIN_NUMBER).build();
        tickets.add(ticket);
        trainSchedule.setTickets(tickets);
        Mockito.when(trainRepository.findByTrainNumber(Mockito.anyInt())).thenReturn(Optional.ofNullable(trainSchedule));
        TrainServiceGetRideDetailsResponseDTO trainServiceGetRideResponseDTO = trainService.getRideDetails(trainServiceGetRideDetailsRequestDTO);
        assertThat(trainServiceGetRideResponseDTO).isNotNull();
        assertThat(trainServiceGetRideResponseDTO.getId()).isEqualTo(INITIAL_ID);
        assertThat(trainServiceGetRideResponseDTO.getTrainServiceGetRideDetailsPassengersResponseDTOs().get(0).getTicketStatus()).isEqualTo(TICKET_STATUS);
        assertThat(trainServiceGetRideResponseDTO.getTrainServiceGetRideDetailsPassengersResponseDTOs().get(0).getTicketNumber()).isEqualTo(TICKET_NUMBER);
        assertThat(trainServiceGetRideResponseDTO.getTrainServiceGetRideDetailsPassengersResponseDTOs().get(0).getPassengerName()).isEqualTo(PASSENGER_NAME);
    }

    @Test
    public void getRideDetails_shouldThrowExceptionWhenRideNotFound()
    {
        TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO = new TrainServiceGetRideDetailsRequestDTO();
        Mockito.when(trainRepository.findByTrainNumber(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            trainService.getRideDetails(trainServiceGetRideDetailsRequestDTO);});
    }



    /*
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
    }*/

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
