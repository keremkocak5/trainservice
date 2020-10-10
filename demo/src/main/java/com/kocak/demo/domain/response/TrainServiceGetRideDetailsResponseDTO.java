package com.kocak.demo.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsResponseDTO extends TrainServiceGetRideResponseDTO {
    @JsonProperty("passengers")
    private List<TrainServiceGetRideDetailsPassengersResponseDTO> trainServiceGetRideDetailsPassengersResponseDTOs;
}
