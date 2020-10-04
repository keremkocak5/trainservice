package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import com.kocak.demo.domain.response.TrainServiceResponseDTO;
import com.kocak.demo.model.TrainSchedule;
import com.kocak.demo.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/scheduling")
public class TrainServiceController {

    @Autowired
    private TrainRepository trainRepository;

    @PostMapping("/addride")
    public BaseResponseDTO addRide(@RequestBody TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        //TrainSchedule tr = new TrainSchedule();
        //tr.setTrainNumber(1);
        //trainRepository.save(tr);
        return baseResponseDTO;
    }

    @PostMapping("/getride")
    public TrainServiceResponseDTO getRide(@RequestBody TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO)
    {
        TrainServiceResponseDTO trainServiceResponseDTO = new TrainServiceResponseDTO();
        Optional<TrainSchedule> m = trainRepository.findByTrainNumber(trainServiceGetRideRequestDTO.getTrainNumber());
        System.out.println(">><" + m.isPresent());
        return trainServiceResponseDTO;
    }

    @PostMapping("/getridedetails")
    public TrainServiceResponseDTO getRideDetails(@RequestBody TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO)
    {
        TrainServiceResponseDTO trainServiceResponseDTO = new TrainServiceResponseDTO();
        return trainServiceResponseDTO;
    }

}