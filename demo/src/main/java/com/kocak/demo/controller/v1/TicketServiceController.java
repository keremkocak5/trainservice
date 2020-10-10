package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import com.kocak.demo.logging.LogExecutionTime;
import com.kocak.demo.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/v1/reservation")
@Api(value = "ticketing application", description = "Ticketing operations")
public class TicketServiceController {

    @Autowired
    private TicketService ticketService;

    @LogExecutionTime
    @PostMapping("/sellticket")
    @ApiOperation(value = "Sell Ticket",
            notes = "Sells customer a ticket and returns BaseResponseDTO")
    public ResponseEntity<?> sellTicket(@Valid @RequestBody TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        ticketService.sellTicket(ticketServiceSellTicketRequestDTO);
        return ResponseEntity.ok(baseResponseDTO);
    }

    @LogExecutionTime
    @PostMapping("/cancelticket")
    @ApiOperation(value = "Cancel Ticket",
            notes = "Cancels a ticket and returns BaseResponseDTO")
    public ResponseEntity<?> cancelTicket(@Valid @RequestBody TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        ticketService.cancelTicket(ticketServiceCancelTicketRequestDTO);
        return ResponseEntity.ok(baseResponseDTO);
    }

}
