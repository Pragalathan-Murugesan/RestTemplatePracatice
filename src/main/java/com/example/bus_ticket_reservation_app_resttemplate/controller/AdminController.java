package com.example.bus_ticket_reservation_app_resttemplate.controller;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import com.example.bus_ticket_reservation_app_resttemplate.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/admin/adduserprofile")
    public ResponseEntity<ApiResponse> addAdmin(@RequestBody CommonDto commonDto){
        return adminService.addAdmin(commonDto);
    }
    @PostMapping(value = "/adminlogin")
    public ResponseEntity<ApiResponse> adminLogin(@RequestBody CommonDto commonDto){
        return adminService.adminLogin(commonDto);
    }

    @PutMapping(value = "/update/user")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody CommonDto commonDto,@RequestHeader("Authorization")String token){
        return adminService.updateUser(commonDto,token);
    }
    @DeleteMapping(value = "/delete/user/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id,@RequestHeader("Authorization")String token){
        return adminService.deleteUser(id,token);
    }
}
