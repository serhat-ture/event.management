package com.blc.eventManagement.controller;

import com.blc.eventManagement.payload.LoginDto;
import com.blc.eventManagement.payload.RegisterDto;
import com.blc.eventManagement.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
//login api
    @PostMapping(value = {"login","/signin"})
    public ResponseEntity<String> login (@RequestBody LoginDto loginDto){
        String response =authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    //register api

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
