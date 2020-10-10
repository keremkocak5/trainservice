package com.kocak.demo.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties
public class TrainServiceAddRideRequestDTO implements Serializable {

    @NotBlank(message = "trainNumber cannot be blank")
    private int trainNumber;

    @NotBlank(message = "departureDate cannot be blank")
    private LocalDate departureDate;

    @NotBlank(message = "initialCapacity cannot be blank")
    @Min(value = 3, message = "initialCapacity cannot be less than 3")
    private int initialCapacity;

    @NotBlank(message = "driverName cannot be blank")
    @NotEmpty(message = "driverName cannot be blank")
    @NotNull(message = "driverName cannot be blank")
    private String driverName;

}
