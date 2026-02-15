package com.vn.toeic.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vn.toeic.entity.AuthBaseUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Response object for login.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginResponse extends BaseResponse {

    /**
     * User information returned after login.
     */
    private Map<String, Object> userData;

    /**
     * JWT access token used for authenticating API requests.
     */
    private String accessToken;

    /**
     * JWT refresh token used for obtaining a new access token.
     */
    @JsonIgnore
    private String refreshToken;

    /**
     * Populate user data from the authenticated user entity.
     *
     * @param authBaseUser the auth base user.
     */
    public void addUserData(AuthBaseUser authBaseUser) {
        userData = new LinkedHashMap<>();
        userData.put("userId", authBaseUser.getUserId());
        userData.put("username", authBaseUser.getUsername());
        userData.put("email", authBaseUser.getEmail());
        userData.put("loginMethod", authBaseUser.getLoginMethod());
        userData.put("firstName", authBaseUser.getFirstName());
        userData.put("lastName", authBaseUser.getLastName());
        userData.put("status", authBaseUser.getStatus());
    }

}
