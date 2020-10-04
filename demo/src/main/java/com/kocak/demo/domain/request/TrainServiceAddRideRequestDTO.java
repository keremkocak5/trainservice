package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TrainServiceAddRideRequestDTO implements Serializable {

    @NotBlank(message = "can't be empty")
    @Size(min=20, max=30)
    private int trainNumber;

    @NotBlank(message = "can't be empty")
    private LocalDate departureDate;

    @NotBlank(message = "can't be empty")
    private int initialCapacity;

    @NotBlank(message = "can't be empty")
    private String driverName;

}
