package com.kocak.demo.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties
public class TrainServiceGetRideRequestDTO implements Serializable {

    @NotNull(message = "trainNumber cannot be blank")
    @Min(20)
    private int trainNumber;

}
