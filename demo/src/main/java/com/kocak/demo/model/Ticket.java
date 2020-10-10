package com.kocak.demo.model;

import com.kocak.demo.enums.TicketStatus;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "Ticket")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int ticketNumber;

    private int trainId;

    private String passengerName;

    private int price;

    private TicketStatus ticketStatus;

}
