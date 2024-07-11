package com.wipro.TicketBooking_IndianRailway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traininfodto {
    public int trainnumber;
    public String trainname;
    public String source;
    public String destination;
    public String departuretime;
    public String arrivaltime;
    public String status;
    public String fare;
    public String duration;
    public String classs;
    public String distance;
}
