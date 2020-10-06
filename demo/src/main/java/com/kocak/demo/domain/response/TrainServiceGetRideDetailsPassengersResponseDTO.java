package com.kocak.demo.domain.response;

import com.kocak.demo.enums.TicketStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainServiceGetRideDetailsPassengersResponseDTO  {
    private int id;
    private int ticketNumber;
    private String passengerName;
    private TicketStatus ticketStatus;
}
