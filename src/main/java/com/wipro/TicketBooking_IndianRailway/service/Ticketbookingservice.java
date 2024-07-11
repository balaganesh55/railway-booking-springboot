package com.wipro.TicketBooking_IndianRailway.service;

import com.wipro.TicketBooking_IndianRailway.dto.Ticketbookingdto;

import java.util.List;

public interface Ticketbookingservice {
    Ticketbookingdto bookticket(int trainnumber, Ticketbookingdto request);

    List<Ticketbookingdto> getTrainInfo(int trainnumber);
}
