package com.khushi.smart_interview_management.controller;

import com.khushi.smart_interview_management.dto.LoginRequest;
import com.khushi.smart_interview_management.dto.LoginResponse;
import com.khushi.smart_interview_management.jwt.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        UserDetails user =
                userDetailsService.loadUserByUsername(request.getEmail());

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}