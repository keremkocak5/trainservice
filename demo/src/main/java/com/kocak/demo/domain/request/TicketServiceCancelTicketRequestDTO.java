package com.kocak.demo.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TicketServiceCancelTicketRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "ticketNumber cannot be blank")
    private int ticketNumber;

}
