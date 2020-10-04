package com.kocak.demo.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsResponseDTO extends TrainServiceGetRideResponseDTO {
    private List<TrainServiceGetRideDetailsPassengersResponseDTO> trainServiceGetRideDetailsPassengersResponseDTOs;
}
