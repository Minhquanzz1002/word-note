package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.common.SystemValue.ProcessResult;
import com.vn.toeic.config.AppProperties;
import com.vn.toeic.request.LoginRequest;
import com.vn.toeic.response.LoginResponse;
import com.vn.toeic.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Controller for login.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class LoginController extends BaseController<LoginRequest, LoginResponse> {

    private final LoginService service;

    private final AppProperties appProperties;

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
        if (Objects.equals(ProcessResult.API_RESPONSE_OK, resultResponse.getProcessResult())) {
            ResponseCookie refreshCookie = ResponseCookie.from("refresh_token", resultResponse.getRefreshToken())
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("Strict")
                    .path(ApiEndpoint.REFRESH_TOKEN)
                    .maxAge(appProperties.getAuth().getRefreshTokenExpirationMilliseconds())
                    .build();

            this.httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());

            return this.buildNormalResponse(request, resultResponse);
        }

        return this.buildBusinessErrorResponse(request, resultResponse);
    }
}
