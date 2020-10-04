package com.kocak.demo.service.impl;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.domain.response.TrainServiceResponseDTO;
import com.kocak.demo.mapper.RideMapper;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.repository.TicketRepository;
import com.kocak.demo.repository.TrainRepository;
import com.kocak.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Component
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    @Transactional
    public void addRide(TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO) {
        TrainSchedule trainSchedule = RideMapper.mapTrainServiceAddRideRequestDtoToTrainSchedule(trainServiceAddRideRequestDTO);
        trainRepository.save(trainSchedule);
    }

    @Override
    public TrainServiceGetRideResponseDTO getRide(TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO) {
        Optional<TrainSchedule>  trainSchedule = trainRepository.findByTrainNumber(trainServiceGetRideRequestDTO.getTrainNumber());
        if (trainSchedule.isPresent())
            return RideMapper.mapTrainScheduleToTrainServiceGetRideResponseDto(trainSchedule.get());
        return null; // kerem burada throw edeyim
    }

    @Override
    public TrainServiceGetRideDetailsResponseDTO getRideDetails(TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO) {
        Optional<TrainSchedule>  trainSchedule = trainRepository.findByTrainNumber(trainServiceGetRideDetailsRequestDTO.getTrainNumber());
        if(trainSchedule.isPresent())
        {
             trainSchedule.get().getTickets();
        }
        /*Optional<Ticket>  ticket = ticketRepository.findByTrainNumber(trainServiceGetRideDetailsRequestDTO.getTrainNumber());
        if(ticket.isPresent())
        {
            ticket.get().getTrainSchedule();
        }*/
        return null;
    }
}
