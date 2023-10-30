package com.example.bus_ticket_reservation_app_resttemplate.service;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import com.example.bus_ticket_reservation_app_resttemplate.global_exception.CustomizeException;
import com.example.bus_ticket_reservation_app_resttemplate.global_exception.IlllegalAuthException;
import com.example.bus_ticket_reservation_app_resttemplate.impleme.AdminImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AdminService implements AdminImple {
    @Autowired
    ApiResponse apiResponse;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<ApiResponse> addAdmin(CommonDto commonDto) {
        ResponseEntity<ApiResponse> response;
        try {
            String url = "http://localhost:8092/admin/api/adduserprofile";
            HttpEntity<CommonDto> entity = new HttpEntity<>(commonDto);
            response = restTemplate.postForEntity(url, entity, ApiResponse.class);
            Object statusCode = response.getStatusCode();
            Object getStatus = HttpStatus.OK;
            if (statusCode != getStatus) {
                throw new IlllegalAuthException();
            }
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

        return new ResponseEntity<>(response.getBody(), HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<ApiResponse> adminLogin(CommonDto commonDto) {
        ResponseEntity<ApiResponse>response;
        try {
            String url = "http://localhost:8092/admin/api/adminlogin";
            HttpEntity<CommonDto> entity = new HttpEntity<>(commonDto);
            response = restTemplate.postForEntity(url, entity, ApiResponse.class);
            Object statusCode = response.getStatusCode();
            Object getStatus = HttpStatus.OK;
            if (statusCode != getStatus) {
                throw new IlllegalAuthException();
            }
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return new ResponseEntity<>(response.getBody(), HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<ApiResponse> updateUser(CommonDto commonDto, String token) {
        ResponseEntity<ApiResponse>response;
        try {
            String uri = "http://localhost:8092/admin/api/update/user";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
            System.out.println("jjjjjjjj"+token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CommonDto> httpEntity = new HttpEntity<>(commonDto,httpHeaders);
            response = restTemplate.exchange(uri,HttpMethod.PUT,httpEntity,ApiResponse.class);
            Object getStatus = HttpStatus.OK;
            Object statusCode = response.getStatusCode();
            if (statusCode != getStatus) {
                throw new IlllegalAuthException();
            }
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return new ResponseEntity<>(response.getBody(), HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<ApiResponse> deleteUser(Long id, String token) {
        ResponseEntity<ApiResponse>response;
        try {
            String url = "http://localhost:8092/admin/api/delete";
            String apiUrl = url + "/user/" + id;
            restTemplate.delete(apiUrl, ApiResponse.class);
            apiResponse.setMessage("user deleted successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(null);
        }catch (NullPointerException e){
            throw new CustomizeException("Not Valid Exception", HttpStatus.INTERNAL_SERVER_ERROR, null);

        }
        return new ResponseEntity<>(apiResponse, HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }
}
