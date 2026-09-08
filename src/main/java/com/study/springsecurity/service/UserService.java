package com.study.springsecurity.service;


import com.study.springsecurity.model.Users;
import com.study.springsecurity.repo.UserRepo;
import com.study.springsecurity.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;

    public Users save(Users users){
        users.setPassword(Utility.encoder.encode(users.getPassword()));
        return userRepo.save(users);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()){
            return "success";
        }
        return "failed";
    }
}
