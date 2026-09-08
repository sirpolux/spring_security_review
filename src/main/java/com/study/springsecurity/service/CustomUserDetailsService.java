package com.study.springsecurity.service;

import com.study.springsecurity.model.User;
import com.study.springsecurity.model.UserPrincipal;
import com.study.springsecurity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
