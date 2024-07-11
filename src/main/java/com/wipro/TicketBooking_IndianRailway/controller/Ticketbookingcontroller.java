package com.wipro.TicketBooking_IndianRailway.controller;

import com.wipro.TicketBooking_IndianRailway.dto.Ticketbookingdto;
import com.wipro.TicketBooking_IndianRailway.service.Ticketbookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticketbooking")
public class Ticketbookingcontroller {

    private Ticketbookingservice service;
    @Autowired
    public Ticketbookingcontroller(Ticketbookingservice service) {
        this.service = service;
    }

    @PostMapping("/{trainnumber}/book")
    public ResponseEntity<Ticketbookingdto> bookTicket(int trainnumber, @RequestBody Ticketbookingdto request) {
        System.out.println("book the tickets ");
        return new ResponseEntity<>(service.bookticket(trainnumber,request), HttpStatus.CREATED);
    }
    @GetMapping("/{trainnumber}/gettraininfo")
    public ResponseEntity<List<Ticketbookingdto>>getTicketbookinginfo(@PathVariable(name="trainnumber") int trainnumber) {
        List<Ticketbookingdto> gettraininfodto = service.getTrainInfo(trainnumber);
        return new ResponseEntity<>(gettraininfodto, HttpStatus.OK);
    }


}
