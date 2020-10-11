package com.kocak.demo.mapper;


import com.kocak.demo.controller.v1.TrainServiceController;
import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsPassengersResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.service.impl.TrainServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RideMapperTest {

    @Test
    public void mapTrainScheduleToTrainServiceGetRideResponseDto_shouldReturnTrainServiceGetRideResponseDTO()
    {
        TrainSchedule trainSchedule = new TrainSchedule();
        trainSchedule.setId(ID);
        trainSchedule.setTrainNumber(TRAIN_NUMBER);
        trainSchedule.setDepartureDate(DEPARTURE_DATE);
        trainSchedule.setDriverName(DRIVER_NAME);
        trainSchedule.setInitialCapacity(INITIAL_CAPACITY);
        TrainServiceGetRideResponseDTO trainServiceGetRideResponseDTO = RideMapper.mapTrainScheduleToTrainServiceGetRideResponseDto(trainSchedule);
        assertThat(trainServiceGetRideResponseDTO).isNotNull();
        assertThat(trainServiceGetRideResponseDTO.getDepartureDate()).isEqualTo(DEPARTURE_DATE);
        assertThat(trainServiceGetRideResponseDTO.getId()).isEqualTo(ID);
    }

    @Test
    public void mapTrainServiceAddRideRequestDtoToTrainSchedule_shouldReturnTrainSchedule()
    {
        TrainServiceAddRideRequestDTO trainServiceAddRideRequestDto = new TrainServiceAddRideRequestDTO();
        trainServiceAddRideRequestDto.setDepartureDate(DEPARTURE_DATE);
        trainServiceAddRideRequestDto.setDriverName(DRIVER_NAME);
        trainServiceAddRideRequestDto.setInitialCapacity(INITIAL_CAPACITY);
        trainServiceAddRideRequestDto.setTrainNumber(TRAIN_NUMBER);
        TrainSchedule trainSchedule = RideMapper.mapTrainServiceAddRideRequestDtoToTrainSchedule(trainServiceAddRideRequestDto);
        assertThat(trainSchedule).isNotNull();
        assertThat(trainSchedule.getDepartureDate()).isEqualTo(DEPARTURE_DATE);
        assertThat(trainSchedule.getId()).isEqualTo(INITIAL_ID);
        assertThat(trainSchedule.getDriverName()).isEqualTo(DRIVER_NAME);
        assertThat(trainSchedule.getInitialCapacity()).isEqualTo(INITIAL_CAPACITY);
        assertThat(trainSchedule.getTrainNumber()).isEqualTo(TRAIN_NUMBER);
    }

    @Test
    public void mapTicketToTrainServiceGetRideDetailsPassengersResponseDTO_shouldReturnTrainServiceGetRideDetailsPassengersResponseDTO()
    {
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TICKET_STATUS);
        ticket.setId(ID);
        ticket.setPassengerName(PASSENGER_NAME);
        ticket.setPrice(PRICE);
        ticket.setTicketNumber(TICKET_NUMBER);
        ticket.setTrainId(TRAIN_NUMBER);
        TrainServiceGetRideDetailsPassengersResponseDTO trainServiceGetRideDetailsPassengersResponseDTO =  RideMapper.mapTicketToTrainServiceGetRideDetailsPassengersResponseDTO(ticket);
        assertThat(trainServiceGetRideDetailsPassengersResponseDTO).isNotNull();
        assertThat(trainServiceGetRideDetailsPassengersResponseDTO.getId()).isEqualTo(ID);
        assertThat(trainServiceGetRideDetailsPassengersResponseDTO.getPassengerName()).isEqualTo(PASSENGER_NAME);
        assertThat(trainServiceGetRideDetailsPassengersResponseDTO.getTicketNumber()).isEqualTo(TICKET_NUMBER);
        assertThat(trainServiceGetRideDetailsPassengersResponseDTO.getTicketStatus()).isEqualTo(TICKET_STATUS);
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
