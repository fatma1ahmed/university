package com.fatma.university.security;

import com.fatma.university.security.dto.LoginRequest;
import com.fatma.university.security.dto.LoginResponse;
import com.fatma.university.security.dto.UpdatePasswordDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/auth")
@Tag(name = "Security Endpoints")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ForgetPasswordService forgetPasswordService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        System.out.println("After Auth");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        System.out.println("Before Response");
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(userDetails.getId());
        loginResponse.setEmail(userDetails.getEmail());
        loginResponse.setUserRole(userDetails.getUserRole());
        return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
//        return new ResponseEntity<>(authentication.getPrincipal(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/sendOtp")
    public ResponseEntity<?> sendOtp(@RequestParam String email) {
        return new ResponseEntity<>(forgetPasswordService.sendOtp(email), HttpStatus.OK);
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto) {
        return new ResponseEntity<>(forgetPasswordService.forgetPassword(updatePasswordDto), HttpStatus.ACCEPTED);
    }


}
