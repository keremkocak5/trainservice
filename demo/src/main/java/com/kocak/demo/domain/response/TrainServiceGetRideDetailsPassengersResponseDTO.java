package com.kocak.demo.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsPassengersResponseDTO  {
    private String ticketNumber;
    private String passengerName;
}
