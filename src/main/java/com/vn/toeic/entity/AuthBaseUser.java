package com.vn.toeic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity representing a base authenticated user.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthBaseUser extends BaseEntity {
    /**
     * The unique identifier of the user.
     */
    private Integer userId;

    /**
     * The username used for authentication.
     */
    private String username;

    /**
     * The encrypted password of the user.
     */
    private String password;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The login method of the user (e.g. PASSWORD, GOOGLE, FACEBOOK).
     */
    private String loginMethod;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The status of the user account.
     */
    private String status;

    /**
     * Association.
     */
    private Role role;

}
