package com.kocak.demo.enums;

import lombok.Getter;

public enum TicketStatus {

    VALID(1),
    CANCELLED(2);

    @Getter
    private int statusCode;

    TicketStatus(int statusCode)
    {
        this.statusCode = statusCode;
    }
}
