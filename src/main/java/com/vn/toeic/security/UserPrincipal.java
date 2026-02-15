package com.vn.toeic.security;

import com.vn.toeic.common.Constant;
import com.vn.toeic.entity.AuthBaseUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
    private Integer userId;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String status;

    public static UserPrincipal create(AuthBaseUser user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        return new UserPrincipal(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(authority),
                user.getStatus()
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(Constant.UserStatus.ACTIVE, status);
    }
}