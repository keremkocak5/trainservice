package com.kocak.demo.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class TicketServiceSellTicketRequestDTO implements Serializable {

    @NotBlank(message = "can't be empty")
    private int ticketNumber;

    @NotBlank(message = "can't be empty")
    private int trainNumber;

    @NotBlank(message = "can't be empty")
    private String passengerName;

    private int price;

}
