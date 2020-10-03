package com.kocak.demo.controller.v1;

import com.kocak.demo.domain.request.TicketServiceCancelTicketRequestDTO;
import com.kocak.demo.domain.request.TicketServiceSellTicketRequestDTO;
import com.kocak.demo.domain.request.TrainServiceAddRideRequestDTO;
import com.kocak.demo.domain.response.BaseResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
public class TicketServiceController {

    @PostMapping("/sellticket")
    public BaseResponseDTO sellTicket(@RequestBody TicketServiceSellTicketRequestDTO ticketServiceSellTicketRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        return baseResponseDTO;
    }

    @PostMapping("/cancelticket")
    public BaseResponseDTO cancelTicket(@RequestBody TicketServiceCancelTicketRequestDTO ticketServiceCancelTicketRequestDTO)
    {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        return baseResponseDTO;
    }

}
