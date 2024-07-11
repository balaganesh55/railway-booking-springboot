package com.wipro.TicketBooking_IndianRailway.controller;

import com.wipro.TicketBooking_IndianRailway.dto.Traininfodto;
import com.wipro.TicketBooking_IndianRailway.service.Traininfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traininfo")
public class Traininfocontroller {

    @Autowired
    private Traininfoservice service;

    @PostMapping("/addtraininfo")
    public ResponseEntity<Traininfodto> addtraininfo( @RequestBody Traininfodto traininfodto) {
        Traininfodto savetraininfodto = service.addtraininfo(traininfodto);
        return new ResponseEntity<>( savetraininfodto,HttpStatus.CREATED);
    }





}
