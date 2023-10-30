package com.example.bus_ticket_reservation_app_resttemplate.api_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ApiResponse {
    private String message;
    private Object status;
    private Object data;
}
