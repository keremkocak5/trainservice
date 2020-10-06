package com.kocak.demo.mapper;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsPassengersResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;

public class RideMapper {

    public static TrainSchedule mapTrainServiceAddRideRequestDtoToTrainSchedule(TrainServiceAddRideRequestDTO trainServiceAddRideRequestDto) {
        return TrainSchedule.builder().trainNumber(trainServiceAddRideRequestDto.getTrainNumber()).departureDate(trainServiceAddRideRequestDto.getDepartureDate()).driverName(trainServiceAddRideRequestDto.getDriverName()).initialCapacity(trainServiceAddRideRequestDto.getInitialCapacity()).build();
    }

    public static TrainServiceGetRideResponseDTO mapTrainScheduleToTrainServiceGetRideResponseDto(TrainSchedule trainSchedule)
    {
        TrainServiceGetRideResponseDTO trainServiceGetRideResponseDTO = new TrainServiceGetRideResponseDTO();
        trainServiceGetRideResponseDTO.setDepartureDate(trainSchedule.getDepartureDate());
        trainServiceGetRideResponseDTO.setId(trainSchedule.getId());
        return trainServiceGetRideResponseDTO;
    }

    public static TrainServiceGetRideDetailsPassengersResponseDTO mapTicketToTrainServiceGetRideDetailsPassengersResponseDTO(Ticket ticket)
    {
        TrainServiceGetRideDetailsPassengersResponseDTO trainServiceGetRideDetailsPassengersResponseDTO = new TrainServiceGetRideDetailsPassengersResponseDTO();
        trainServiceGetRideDetailsPassengersResponseDTO.setPassengerName(ticket.getPassengerName());
        trainServiceGetRideDetailsPassengersResponseDTO.setTicketNumber(ticket.getTicketNumber());
        trainServiceGetRideDetailsPassengersResponseDTO.setTicketStatus(ticket.getTicketStatus());
        trainServiceGetRideDetailsPassengersResponseDTO.setId(ticket.getId());
        return  trainServiceGetRideDetailsPassengersResponseDTO;
    }
}
