package com.example.RestTemplatePracatice.Service;

import com.example.RestTemplatePracatice.Entity.ApiRes;
import com.example.RestTemplatePracatice.Entity.ApiRes1;
import com.example.RestTemplatePracatice.Entity.User;
import com.example.RestTemplatePracatice.Entity.Users;
import com.example.RestTemplatePracatice.GlobalException.MethodArgumentsNotFoundException;
import com.example.RestTemplatePracatice.GlobalException.NotSatisfiedException;
import com.example.RestTemplatePracatice.Implements.UserImple;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements UserImple {
    RestTemplate restTemplate = new RestTemplate();
    User user= new User();
    @Override
    public ResponseEntity<ApiRes1> addUser(User user) throws Exception {
        ResponseEntity<ApiRes1> response;
        try {
            HttpEntity<User> entity = new HttpEntity<>(user);
            String url = "http://localhost:8081/api/adduser";
            response = restTemplate.postForEntity(url, entity, ApiRes1.class);
            Object statusCode = response.getStatusCode();
            Object getStatus = HttpStatus.OK.value();
            if (statusCode != getStatus) {
                throw new NotSatisfiedException();
            }
        } catch (NotSatisfiedException e) {
            throw new NotSatisfiedException();
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ApiRes1> login(User user) throws Exception {

            HttpEntity<User> entity = new HttpEntity<>(user);
            String url = "http://localhost:8081/api/login";

            ResponseEntity<ApiRes1> response = restTemplate.postForEntity(url, entity, ApiRes1.class);
            Object status = response.getStatusCode();
            Object code = HttpStatus.OK;
            System.out.println(status);
            System.out.println(code);
            try {
//            if (status.equals(HttpStatus.OK))
//                return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
             if (status != code)
                throw new NotSatisfiedException();

        } catch (NotSatisfiedException e) {
            throw new NotSatisfiedException();
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

    }
    @Override
    public ResponseEntity<ApiRes> getusers() throws Exception {

        String url = "http://localhost:8081/api/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Users> entity = new HttpEntity<Users>(httpHeaders);
        ResponseEntity<ApiRes> response = restTemplate.exchange(url,HttpMethod.GET,entity,ApiRes.class);
        Object statusCode = response.getStatusCode();
            Object status = response.getStatusCode();
            Object code = HttpStatus.OK;
            System.out.println(status);
            System.out.println(code);
            try {
                if (status != code)
                    throw new MethodArgumentsNotFoundException();

            } catch (MethodArgumentsNotFoundException e) {
                throw new MethodArgumentsNotFoundException();
            }
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }


    public Object update( Long id) {
        String url = "http://localhost:8081/api/update/{id}";
        Map<String,Long> param =new HashMap<String,Long>();
        param.put("id", id);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<User> entity = new HttpEntity<User>(httpHeaders);
        return restTemplate.patchForObject(url,param,Object.class);

    }
    @Override
    public void delete(Long id) {
        String url = "http://localhost:8081/api/deletebyid/{id}";
        Map<String,Long> param = new HashMap<String,Long>();
        param.put("id",id);
        restTemplate.delete(url, param);
    }
}