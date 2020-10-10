package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "trainNumber cannot be blank or zero")
    @NotBlank(message = "trainNumber cannot be blank or zero")
    @NotNull(message = "trainNumber cannot be blank or zero")
    @Min(value = 10, message = "trainNumber cannot be blank or zero")
    private int trainNumber;

}
