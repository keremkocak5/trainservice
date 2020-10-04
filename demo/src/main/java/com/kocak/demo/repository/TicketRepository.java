package com.kocak.demo.repository;

import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
