package com.example.bus_ticket_reservation_app_resttemplate.impleme;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import org.springframework.http.ResponseEntity;

public interface UserImpl {
    ResponseEntity<ApiResponse> signUp(CommonDto commonDto);

    ResponseEntity<ApiResponse> login(CommonDto commonDto);

    ResponseEntity<ApiResponse> getAvailability(String token);

    ResponseEntity<ApiResponse> bookTicket(CommonDto commonDto,String token) throws Exception;

   ResponseEntity<ApiResponse> cancelTicket(CommonDto commonDto,String token);

   ResponseEntity<ApiResponse>  changePassword(CommonDto commonDto,String token);

    ResponseEntity<ApiResponse> forgotPassword(CommonDto commonDto,String token);

    ResponseEntity<ApiResponse> resetPassword(CommonDto commonDto, String token);
}
