package com.kocak.demo.config;

import com.kocak.demo.enums.TicketStatus;
import com.kocak.demo.model.Ticket;
import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.repository.TicketRepository;
import com.kocak.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TrainSchedule ts = TrainSchedule.builder().trainNumber(10).initialCapacity(100).driverName("keremkocak").departureDate(LocalDate.of(2020, 01,01)).build();
        trainRepository.save(ts);
        trainRepository.flush();
        Ticket ticket = Ticket.builder().passengerName("elif").ticketNumber(1).trainId(1).ticketStatus(TicketStatus.VALID).price(8).build();
        ticketRepository.save(ticket);
        ticket = Ticket.builder().passengerName("kerem").ticketNumber(2).trainId(1).ticketStatus(TicketStatus.VALID).price(10).build();
        ticketRepository.save(ticket);
    }
}
