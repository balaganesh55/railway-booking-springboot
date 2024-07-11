package com.wipro.TicketBooking_IndianRailway.repository;

import com.wipro.TicketBooking_IndianRailway.model.Ticketbooking;
import com.wipro.TicketBooking_IndianRailway.model.Traininfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface Traininforepo extends JpaRepository<Traininfo,Integer> {


    Optional<Traininfo> findByTrainnumber(int trainnumber);
}
