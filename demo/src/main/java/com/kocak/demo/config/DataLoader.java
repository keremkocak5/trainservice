package com.kocak.demo.config;

import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        TrainSchedule ts = TrainSchedule.builder().trainNumber(10).initialCapacity(100).driverName("keremkocak").build();
        ts.setTrainNumber(10);
        trainRepository.save(ts);
    }
}
