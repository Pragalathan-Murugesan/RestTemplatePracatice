package com.example.RestTemplatePracatice.Controller;

import com.example.RestTemplatePracatice.Entity.ApiRes;
import com.example.RestTemplatePracatice.Entity.ApiRes1;
import com.example.RestTemplatePracatice.Entity.User;
import com.example.RestTemplatePracatice.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resttemplate/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/add/user")
    public ResponseEntity<ApiRes1> addUser(@Valid @RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ApiRes1> login(@RequestBody User user) throws Exception {
        return userService.login(user);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<ApiRes> getusers() throws Exception {
        return userService.getusers();
    }

    @PatchMapping(value = "/update/{id}")
    public Object update(@PathVariable("id") Long id) {
        return userService.update(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
         userService.delete(id);
    }
}
