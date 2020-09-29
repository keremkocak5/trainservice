package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import com.kocak.demo.domain.response.TrainServiceResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/scheduling")
public class TrainServiceController {

    @PostMapping("/addride")
    public BaseResponseDTO addRide(@RequestBody TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        return baseResponseDTO;
    }

    @PostMapping("/getride")
    public TrainServiceResponseDTO getRide(@RequestBody TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO)
    {
        TrainServiceResponseDTO trainServiceResponseDTO = new TrainServiceResponseDTO();
        return trainServiceResponseDTO;
    }

    @PostMapping("/getridedetails")
    public TrainServiceResponseDTO getRideDetails(@RequestBody TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO)
    {
        TrainServiceResponseDTO trainServiceResponseDTO = new TrainServiceResponseDTO();
        return trainServiceResponseDTO;
    }

}
