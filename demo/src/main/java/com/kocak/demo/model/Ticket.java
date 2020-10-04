package com.kocak.demo.model;

import lombok.*;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;


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

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainNumber", insertable = false, updatable = false)
    private Set<TrainSchedule> trainSchedule;*/
}
