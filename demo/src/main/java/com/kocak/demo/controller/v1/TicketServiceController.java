package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
@Api(value = "ticketing application", description = "Ticketing operations")
public class TicketServiceController {

    @PostMapping("/sellticket")
    @ApiOperation(value = "Sell Ticket",
            notes = "Sells customer a ticket and returns BaseResponseDTO")
    public BaseResponseDTO sellTicket(@RequestBody TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        return baseResponseDTO;
    }

    @PostMapping("/cancelticket")
    @ApiOperation(value = "Cancel Ticket",
            notes = "Cancels a ticket and returns BaseResponseDTO")
    public BaseResponseDTO cancelTicket(@RequestBody TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        return baseResponseDTO;
    }

}
