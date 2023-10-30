package com.example.bus_ticket_reservation_app_resttemplate.service;

import com.example.bus_ticket_reservation_app_resttemplate.api_response.ApiResponse;
import com.example.bus_ticket_reservation_app_resttemplate.dto.CommonDto;
import com.example.bus_ticket_reservation_app_resttemplate.global_exception.CustomizeException;
import com.example.bus_ticket_reservation_app_resttemplate.global_exception.IlllegalAuthException;
import com.example.bus_ticket_reservation_app_resttemplate.impleme.UserImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements UserImpl {
@Autowired
private ApiResponse apiResponse;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<ApiResponse> signUp(CommonDto commonDto) {
        ResponseEntity<ApiResponse> response;
        try {
          String url = "http://localhost:8092/user/api/signup";
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
    public ResponseEntity<ApiResponse> login(CommonDto commonDto) {
        ResponseEntity<ApiResponse> response;
        try {
            String url = "http://localhost:8092/user/api/login";
            HttpEntity<CommonDto> httpEntity = new HttpEntity<>(commonDto);
            response = restTemplate.postForEntity(url, httpEntity, ApiResponse.class);
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

    public ResponseEntity<ApiResponse> getAvailability(String token) {
        ResponseEntity<ApiResponse>response;
        try {
            CommonDto commonDto = new CommonDto();
            String url = "http://localhost:8092/user/api/get/availability";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
            HttpEntity<CommonDto> httpEntity = new HttpEntity<>(commonDto,httpHeaders);
            response = restTemplate.exchange(url,HttpMethod.GET,httpEntity,ApiResponse.class);
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
    public ResponseEntity<ApiResponse> bookTicket(CommonDto commonDto,String token) throws Exception {
        ResponseEntity<ApiResponse> response;
        try {
            String uri = "http://localhost:8092/user/api/book/ticket";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CommonDto> httpEntity = new HttpEntity<>(commonDto,httpHeaders);
            response = restTemplate.postForEntity(uri, httpEntity, ApiResponse.class);
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
    public ResponseEntity<ApiResponse> cancelTicket(CommonDto commonDto,String token) {
        ResponseEntity<ApiResponse> response;
        try {
            String uri = "http://localhost:8092/user/api/delete/oneticket";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
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
    public ResponseEntity<ApiResponse> changePassword(CommonDto commonDto,String token) {
        ResponseEntity<ApiResponse>response;
        try {
            String uri = "http://localhost:8092/user/api/change/password";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
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
    public ResponseEntity<ApiResponse> forgotPassword(CommonDto commonDto,String token) {
        ResponseEntity<ApiResponse>response;
        try {
            String uri = "http://localhost:8092/user/api/forgot/password";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CommonDto> httpEntity = new HttpEntity<>(commonDto,httpHeaders);
            response = restTemplate.postForEntity(uri, httpEntity, ApiResponse.class);
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
    public ResponseEntity<ApiResponse> resetPassword(CommonDto commonDto, String token) {
        ResponseEntity<ApiResponse>response;
        try {
            String uri = "http://localhost:8092/user/api/reset/password";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization",token);
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
}
