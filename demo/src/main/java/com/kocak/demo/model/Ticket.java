package com.kocak.demo.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;


@Getter
@Setter
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    private int ticketNumber;

    private int trainNumber;

    private String passengerName;
}
