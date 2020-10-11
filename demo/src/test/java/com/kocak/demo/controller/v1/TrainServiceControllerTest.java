package com.kocak.demo.controller.v1;


import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideDetailsRequestDTO;
import com.kocak.demo.domain.request.TrainServiceGetRideRequestDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideDetailsResponseDTO;
import com.kocak.demo.domain.response.TrainServiceGetRideResponseDTO;
import com.kocak.demo.service.impl.TrainServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TrainServiceControllerTest {

    @InjectMocks
    private TrainServiceController trainServiceController;

    @Mock
    private TrainServiceImpl trainServiceImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addRide_shouldReturnHttpOk() {
        TrainServiceAddRideRequestDTO dto = new TrainServiceAddRideRequestDTO();
        Mockito.doNothing().when(trainServiceImpl).addRide(Mockito.any(TrainServiceAddRideRequestDTO.class));
        ResponseEntity<?> responseEntity = trainServiceController.addRide(dto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getRide_shouldReturnHttpOk() {
        TrainServiceGetRideRequestDTO dto = new TrainServiceGetRideRequestDTO();
        TrainServiceGetRideResponseDTO response = new TrainServiceGetRideResponseDTO();
        Mockito.when(trainServiceImpl.getRide(Mockito.any(TrainServiceGetRideRequestDTO.class))).thenReturn(response);
        ResponseEntity<?> responseEntity = trainServiceController.getRide(dto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getRideDetails_shouldReturnHttpOk() {
        TrainServiceGetRideDetailsRequestDTO dto = new TrainServiceGetRideDetailsRequestDTO();
        TrainServiceGetRideDetailsResponseDTO response = new TrainServiceGetRideDetailsResponseDTO();
        Mockito.when(trainServiceImpl.getRideDetails(Mockito.any(TrainServiceGetRideDetailsRequestDTO.class))).thenReturn(response);
        ResponseEntity<?> responseEntity = trainServiceController.getRideDetails(dto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}