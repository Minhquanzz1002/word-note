package com.vn.toeic.service;

import com.vn.toeic.entity.AuthBaseUser;
import com.vn.toeic.repository.AuthBaseUserRepository;
import com.vn.toeic.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserPrincipalService implements UserDetailsService {

    private final AuthBaseUserRepository authBaseUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthBaseUser authBaseUser = authBaseUserRepository.findByUsername(username);
        if (Objects.isNull(authBaseUser)) {
            throw new UsernameNotFoundException("");
        }
        return UserPrincipal.create(authBaseUser);
    }
}
