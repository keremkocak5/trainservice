package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.domain.response.TrainServiceResponseDTO;
import com.kocak.demo.logging.LogExecutionTime;
import com.kocak.demo.service.TrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/scheduling")
@Validated
@Api(value = "train-application", description = "Train schedule operations")
public class TrainServiceController {

    @Autowired
    private TrainService trainService;

    @LogExecutionTime
    @PostMapping("/addride")
    @ApiOperation(value = "Add Ride",
            notes = "Adds a ride to the train schedule repository and returns BaseResponseDTO")
    public ResponseEntity<?> addRide(@Valid @RequestBody TrainServiceAddRideRequestDTO trainServiceAddRideRequestDTO) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        trainService.addRide(trainServiceAddRideRequestDTO);
        return ResponseEntity.ok(baseResponseDTO);
    }

    @LogExecutionTime
    @PostMapping("/getride")
    @ApiOperation(value = "Get Ride",
            notes = "Gets a ride from the train schedule repository in the type of TrainServiceResponseDTO")
    public ResponseEntity<?> getRide(@Valid @RequestBody TrainServiceGetRideRequestDTO trainServiceGetRideRequestDTO) {
        return ResponseEntity.ok(trainService.getRide(trainServiceGetRideRequestDTO));
    }

    @LogExecutionTime
    @PostMapping("/getridedetails")
    @ApiOperation(value = "Get Ride Details",
            notes = "Gets ride details from the train schedule and ticketing repositories in the type of TrainServiceResponseDTO")
    public ResponseEntity<?> getRideDetails(@Valid @RequestBody TrainServiceGetRideDetailsRequestDTO trainServiceGetRideDetailsRequestDTO) {
        return ResponseEntity.ok(trainService.getRideDetails(trainServiceGetRideDetailsRequestDTO));
    }
}