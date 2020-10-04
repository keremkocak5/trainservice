package com.kocak.demo.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

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
