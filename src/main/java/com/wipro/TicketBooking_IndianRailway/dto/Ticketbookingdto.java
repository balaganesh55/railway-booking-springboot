package com.wipro.TicketBooking_IndianRailway.dto;

import lombok.Data;

@Data
public class Ticketbookingdto {
    private int bookingid;
    private String name;
    private String email;
    private String phonenumber;
    private String address;
    private String gender;
    private String password;
    private int age;
    private String noofticket;
    private Traininfodto traininfo;
}
