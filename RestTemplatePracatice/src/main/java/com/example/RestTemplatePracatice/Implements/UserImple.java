package com.example.RestTemplatePracatice.Implements;

import com.example.RestTemplatePracatice.Entity.ApiRes;
import com.example.RestTemplatePracatice.Entity.ApiRes1;
import com.example.RestTemplatePracatice.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserImple {
    ResponseEntity<ApiRes1> addUser(User user) throws Exception;

    ResponseEntity<ApiRes1> login(User user) throws Exception;

     ResponseEntity<ApiRes> getusers() throws Exception;

    Object update(Long id);

    void delete(Long id);
}
