package com.example.Capstone.Project.auth;

import com.example.Capstone.Project.auth.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Capstone.Project.auth.authDTO.UserLoginDTO;
import com.example.Capstone.Project.user.User;
import com.example.Capstone.Project.user.UserSRV;
import com.example.Capstone.Project.exceptions.UnauthorizedException;

@Service
public class AuthSRV {
    @Autowired
    private UserSRV userSRV;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;

    public String autheticateUserAndGenerateToken(UserLoginDTO payload){
        User user = userSRV.findByEmail(payload.email());
        if(bcrypt.matches(payload.password(), user.getPassword())){
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Wrong credentials!");
        }
    }
}
