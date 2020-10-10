package com.kocak.demo.repository;

import com.kocak.demo.model.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<TrainSchedule, Integer> {

    Optional<TrainSchedule> findByTrainNumber(int trainNumber);
}
