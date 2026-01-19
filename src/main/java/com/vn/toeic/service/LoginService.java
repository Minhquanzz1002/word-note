package com.vn.toeic.service;

import com.vn.toeic.common.JwtUtil;
import com.vn.toeic.common.SystemValue.ProcessResult;
import com.vn.toeic.entity.AuthBaseUser;
import com.vn.toeic.repository.AuthBaseUserRepository;
import com.vn.toeic.request.LoginRequest;
import com.vn.toeic.response.LoginResponse;
import com.vn.toeic.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService extends BaseService<LoginRequest, LoginResponse> {

    private final AuthBaseUserRepository authBaseUserRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    protected LoginResponse mainFunc(LoginRequest request) {
        AuthBaseUser authBaseUser = authBaseUserRepository.findByUsername(request.getUsername());

        LoginResponse response = new LoginResponse();

        if (Objects.isNull(authBaseUser) || !passwordEncoder.matches(request.getPassword(), authBaseUser.getPassword())) {
            response.setProcessResult(ProcessResult.API_AUTH_FAILED);
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        response.addUserData(authBaseUser);
        UserPrincipal userPrincipal = UserPrincipal.create(authBaseUser);
        response.setAccessToken(jwtUtil.generateAccessToken(userPrincipal));
        response.setRefreshToken(jwtUtil.generateRefreshToken(userPrincipal));

        return response;
    }
}
