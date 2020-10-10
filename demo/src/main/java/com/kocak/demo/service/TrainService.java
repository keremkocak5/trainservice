package com.kocak.demo.service;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;

public interface TrainService {

    public void addRide(TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO);

    public TrainServiceGetRideResponseDTO getRide(TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO);

    public TrainServiceGetRideDetailsResponseDTO getRideDetails(TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO);

}
