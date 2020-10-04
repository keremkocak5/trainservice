package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter

public class TrainServiceGetRideRequestDTO implements Serializable {

    @NotNull(message = "bos olamaz")
    private int trainNumber;

}
