package com.wipro.TicketBooking_IndianRailway.serviceimplementation;

import com.wipro.TicketBooking_IndianRailway.dto.Ticketbookingdto;
import com.wipro.TicketBooking_IndianRailway.dto.Traininfodto;
import com.wipro.TicketBooking_IndianRailway.model.Ticketbooking;
import com.wipro.TicketBooking_IndianRailway.model.Traininfo;
import com.wipro.TicketBooking_IndianRailway.repository.Ticketbookingrepo;
import com.wipro.TicketBooking_IndianRailway.repository.Traininforepo;
import com.wipro.TicketBooking_IndianRailway.service.Traininfoservice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Traininfoserviceimpl implements Traininfoservice {
    @Autowired
    private Traininforepo repo;
    @Autowired
    private Ticketbookingrepo ticketrepo;
    @Autowired
    private ModelMapper mapper;


    @Override
    public Traininfodto addtraininfo(Traininfodto traininfo) {
        Traininfo info=TraininfoDtoToEntity(traininfo);
        Traininfo obj = repo.save(info);
        return entityToTraininfoDto(obj);

    }

    private Traininfo TraininfoDtoToEntity(Traininfodto obj) {
        Traininfo traininfo=new Traininfo();
        traininfo.setTrainnumber(obj.getTrainnumber());
        traininfo.setTrainname(obj.getTrainname());
        traininfo.setClasss(obj.getClasss());
        traininfo.setArrivaltime(obj.getArrivaltime());
        traininfo.setDeparturetime(obj.getDeparturetime());
        traininfo.setFare(obj.getFare());
        traininfo.setSource(obj.getSource());
        traininfo.setStatus(obj.getStatus());
        traininfo.setDistance(obj.getDistance());
        traininfo.setDuration(obj.getDuration());
        traininfo.setDestination(obj.getDestination());
        return traininfo;
    }
    private Traininfodto entityToTraininfoDto(Traininfo obj) {
        Traininfodto traininfo=new Traininfodto();
        traininfo.setTrainnumber(obj.getTrainnumber());
        traininfo.setTrainname(obj.getTrainname());
        traininfo.setClasss(obj.getClasss());
        traininfo.setArrivaltime(obj.getArrivaltime());
        traininfo.setDeparturetime(obj.getDeparturetime());
        traininfo.setFare(obj.getFare());
        traininfo.setSource(obj.getSource());
        traininfo.setStatus(obj.getStatus());
        traininfo.setDistance(obj.getDistance());
        traininfo.setDuration(obj.getDuration());
        traininfo.setDestination(obj.getDestination());
        return traininfo;
    }

}
