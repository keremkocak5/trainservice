package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsRequestDTO  implements Serializable {

    @NotBlank(message = "can't be empty")
    int trainNumber;
    
}
