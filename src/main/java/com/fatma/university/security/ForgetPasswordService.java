package com.fatma.university.security;

import org.springframework.stereotype.Service;

@Service
public interface ForgetPasswordService {

    public String sendOtp(String email);
    public String forgetPassword(UpdatePasswordDto updatePasswordDto);
}
