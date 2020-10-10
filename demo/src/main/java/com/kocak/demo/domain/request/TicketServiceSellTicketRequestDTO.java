package com.kocak.demo.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class TicketServiceSellTicketRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "ticketNumber cannot be blank")
    private int ticketNumber;

    @NotBlank(message = "trainNumber cannot be blank")
    private int trainNumber;

    @NotBlank(message = "passengerName cannot be blank")
    private String passengerName;

    @NotBlank(message = "price cannot be blank")
    private int price;

}
