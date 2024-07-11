package com.wipro.TicketBooking_IndianRailway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticketbooking", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "phonenumber"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticketbooking {
    @Id
    public int bookingid; // pk
    public String name;
    public String email;
    public String phonenumber;
    public String address;
    public String gender;
    public String password;
    public int age;
    public String noofticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainnumber", referencedColumnName = "trainnumber")
    public Traininfo traininfo;
}
