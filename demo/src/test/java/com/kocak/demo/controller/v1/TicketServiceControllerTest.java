package com.kocak.demo.controller.v1;


import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.service.impl.TicketServiceImpl;
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
public class TicketServiceControllerTest {

    @InjectMocks
    public TicketServiceController ticketServiceController;

    @Mock
    public TicketServiceImpl ticketServiceImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sellTicket_shouldReturnHttpOk() {
        TicketServiceSellTicketRequestDTO dto = TicketServiceSellTicketRequestDTO.builder().trainNumber(1).build();
        Mockito.doNothing().when(ticketServiceImpl).sellTicket(Mockito.any(TicketServiceSellTicketRequestDTO.class));
        ResponseEntity<?> responseEntity = ticketServiceController.sellTicket(dto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void cancelTicket_shouldReturnHttpOk() {
        TicketServiceCancelTicketRequestDTO dto = new TicketServiceCancelTicketRequestDTO();
        Mockito.doNothing().when(ticketServiceImpl).cancelTicket(Mockito.any(TicketServiceCancelTicketRequestDTO.class));
        ResponseEntity<?> responseEntity = ticketServiceController.cancelTicket(dto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
