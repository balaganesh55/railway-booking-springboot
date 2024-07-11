package com.wipro.TicketBooking_IndianRailway;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketBookingIndianRailwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingIndianRailwayApplication.class, args);
	}
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
