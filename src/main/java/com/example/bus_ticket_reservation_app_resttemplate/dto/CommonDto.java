package com.example.bus_ticket_reservation_app_resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonDto {

    private Long id;
    private String name;
    private String emailID;
    private String password;
    private String role;
    private Long createAt;
//    private UserProfile userProfile;
    private String gender;
    private Long age;
    private Long phoneNumber;
    private String ticketStatus;
    private Long ticketCount;
    private Long loginAt;
    private Long UpdateAt;
    private Long userId;
    private Long totalNumberOfTickets;
    private Long deleteTicket;
    private String newPassword;
    private String confirmPassword;
    private Long otpNumber;
    private Object userProfile;
   private LocalDate date;

}
