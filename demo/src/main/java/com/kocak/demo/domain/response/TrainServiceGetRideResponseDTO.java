package com.kocak.demo.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideResponseDTO extends BaseResponseDTO {
    private int id;
    private LocalDate departureDate;
}
