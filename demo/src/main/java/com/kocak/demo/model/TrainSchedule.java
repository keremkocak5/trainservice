package com.kocak.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TrainSchedule")
@Builder
@NoArgsConstructor
public class TrainSchedule {

    @Id
    private int trainNumber;

    private LocalTime departureDate;

    private int initialCapacity;

    private String driverName;

    public TrainSchedule(int trainNumber, LocalTime departureDate, int initialCapacity, String driverName)
    {
        this.trainNumber = trainNumber;
        this.departureDate = departureDate;
        this.initialCapacity = initialCapacity;
        this.driverName = driverName;
    }
}
