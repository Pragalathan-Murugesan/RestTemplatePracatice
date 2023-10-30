package com.example.bus_ticket_reservation_app_resttemplate.impleme;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import org.springframework.http.ResponseEntity;

public interface AdminImple {
    ResponseEntity<ApiResponse> addAdmin(CommonDto commonDto);

    ResponseEntity<ApiResponse> adminLogin(CommonDto commonDto);

    ResponseEntity<ApiResponse> updateUser(CommonDto commonDto, String token);

    ResponseEntity<ApiResponse> deleteUser(Long id, String token);
}
