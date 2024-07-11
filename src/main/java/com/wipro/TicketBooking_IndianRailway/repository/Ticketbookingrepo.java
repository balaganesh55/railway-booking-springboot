package com.wipro.TicketBooking_IndianRailway.repository;

import com.wipro.TicketBooking_IndianRailway.model.Ticketbooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ticketbookingrepo extends JpaRepository<Ticketbooking, Integer> {
    List<Ticketbooking> findAllByTraininfo_Trainnumber(int trainnumber);
}
