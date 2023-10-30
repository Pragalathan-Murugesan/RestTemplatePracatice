package com.example.bus_ticket_reservation_app_resttemplate.controller;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import com.example.bus_ticket_reservation_app_resttemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody CommonDto commonDto){
        return userService.signUp(commonDto);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> login(@RequestBody CommonDto commonDto){
        return userService.login(commonDto);
    }
    @GetMapping(value = "/ticket/availability")
    public ResponseEntity<ApiResponse> getAvailability(@RequestHeader("Authorization") String token){
        return userService.getAvailability(token);
    }

    @PostMapping(value = "/book/ticket")
    public ResponseEntity<ApiResponse> bookTicket(@RequestBody CommonDto commonDto,@RequestHeader("Authorization") String token) throws Exception {
        return userService.bookTicket(commonDto,token);
    }
    @PutMapping(value = "/cancel/ticket")
    public ResponseEntity<ApiResponse> cancelTicket(@RequestBody CommonDto commonDto,@RequestHeader("Authorization") String token){
        return userService.cancelTicket(commonDto,token);
    }
   @PutMapping(value = "/change/password")
    public ResponseEntity<ApiResponse> changePassword(@RequestBody CommonDto commonDto,@RequestHeader("Authorization") String token){
        return userService.changePassword(commonDto,token);
   }
   @PostMapping(value = "/forgot/password")
    public ResponseEntity<ApiResponse> forgotPassword(@RequestBody CommonDto commonDto,@RequestHeader("Authorization") String token){
        return userService.forgotPassword(commonDto,token);
   }
   @PutMapping(value = "/reset/password")
    public ResponseEntity<ApiResponse> resetPassword(@RequestBody CommonDto commonDto,@RequestHeader("Authorization") String token){
        return userService.resetPassword(commonDto,token);
   }
}
