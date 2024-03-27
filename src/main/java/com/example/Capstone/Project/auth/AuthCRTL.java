package com.example.Capstone.Project.auth;

import com.example.Capstone.Project.auth.authDTO.LoginRegisterDTO;
import com.example.Capstone.Project.auth.authDTO.UserLoginDTO;
import com.example.Capstone.Project.user.User;
import com.example.Capstone.Project.user.UserDTO;
import com.example.Capstone.Project.user.UserSRV;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthCRTL {
    @Autowired
    private AuthSRV authSRV;
    @Autowired
    private UserSRV userSRV;


    @PostMapping("/login")
    public LoginRegisterDTO login(@RequestBody @Validated UserLoginDTO payload, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        return new LoginRegisterDTO(authSRV.autheticateUserAndGenerateToken(payload));
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody @Validated UserDTO userDTO, BindingResult validation) throws IOException {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }

        return this.userSRV.save(userDTO);
    }
}
