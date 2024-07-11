package com.wipro.TicketBooking_IndianRailway.serviceimplementation;

import com.wipro.TicketBooking_IndianRailway.dto.Ticketbookingdto;
import com.wipro.TicketBooking_IndianRailway.dto.Traininfodto;
import com.wipro.TicketBooking_IndianRailway.model.Ticketbooking;
import com.wipro.TicketBooking_IndianRailway.model.Traininfo;
import com.wipro.TicketBooking_IndianRailway.repository.Ticketbookingrepo;
import com.wipro.TicketBooking_IndianRailway.repository.Traininforepo;
import com.wipro.TicketBooking_IndianRailway.service.Ticketbookingservice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Ticketbookingserviceimpl implements Ticketbookingservice {
    @Autowired
    private Ticketbookingrepo repo;
    @Autowired
    private Traininforepo traininforepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Ticketbookingdto bookticket(int trainnumber, Ticketbookingdto request) {
        Traininfo traininfo = traininforepo.findByTrainnumber(trainnumber)
                .orElseThrow(() -> new RuntimeException("Train is not found"));

        Ticketbooking booking = mapper.map(request, Ticketbooking.class);
        booking.setTraininfo(traininfo);

        Ticketbooking savedBooking = repo.save(booking);

        return mapper.map(savedBooking, Ticketbookingdto.class);
    }

    @Override
    public List<Ticketbookingdto> getTrainInfo(int trainnumber) {
        traininforepo.findById(trainnumber).orElseThrow(() -> new RuntimeException("Train number is not found"));

        List<Ticketbooking> ticketInfos = repo.findAllByTraininfo_Trainnumber(trainnumber);

        return ticketInfos.stream()
                .map(info -> mapper.map(info, Ticketbookingdto.class))
                .collect(Collectors.toList());
    }

//    private Ticketbooking TicketbookingDtoToEntity(Ticketbookingdto request) {
//        Ticketbooking booking = mapper.map(request, Ticketbooking.class);
//        // Set Traininfo if needed
//        if (request.getTraininfo() != null) {
//            Traininfo traininfo = traininforepo.findById(request.getTraininfo().getTrainnumber())
//                    .orElseThrow(() -> new RuntimeException("Train number is not found"));
//            booking.setTraininfo(traininfo);
//        }
//        return booking;
//    }

    private Ticketbookingdto entityToTicketbookingDto(Ticketbooking savedBooking) {
        return mapper.map(savedBooking, Ticketbookingdto.class);
    }
}
