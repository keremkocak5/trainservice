package com.kocak.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TrainSchedule")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int trainNumber;

    private LocalDate departureDate;

    private int initialCapacity;

    private String driverName;

    @OneToMany(mappedBy = "trainId")
    private List<Ticket> tickets;

}
