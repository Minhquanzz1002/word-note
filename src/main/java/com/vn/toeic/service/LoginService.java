package com.vn.toeic.service;

import com.vn.toeic.request.LoginRequest;
import com.vn.toeic.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService extends BaseService<LoginRequest, LoginResponse> {
    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    protected LoginResponse mainFunc(LoginRequest request) {
        return new LoginResponse();
    }
}
