package com.kocak.demo.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideResponseDTO extends BaseResponseDTO {
    private int id;
    private LocalDate departureDate;
}
