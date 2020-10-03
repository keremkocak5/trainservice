package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class TicketServiceCancelTicketRequestDTO implements Serializable {

    @NotBlank(message = "can't be empty")
    private int trainNumber;

}
