package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.LoginRequest;
import com.vn.toeic.response.LoginResponse;
import com.vn.toeic.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for login.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class LoginController extends BaseController<LoginRequest, LoginResponse> {

    private final LoginService service;

    /**
     * Handles POST requests for login.
     *
     * @param request containing login data
     * @return a {@link ResponseEntity} containing {@link LoginResponse}
     */
    @PostMapping(ApiEndpoint.LOGIN)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse();
        return this.execute(request, response);
    }

    /**
     * Business processing.
     *
     * @param request  the request
     * @param response the response
     * @return {@link ResponseEntity} with success response
     */
    @Override
    ResponseEntity<LoginResponse> process(LoginRequest request, LoginResponse response) {
        LoginResponse resultResponse = this.service.execute(request);

        return this.buildNormalResponse(request, resultResponse);
    }
}
