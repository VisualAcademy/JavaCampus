package com.hawaso.javacampus.services.identity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hawaso.javacampus.models.identity.AspNetUser;

public class JavaCampusUserDetails implements UserDetails {
    private final AspNetUser user;
    private final Collection<? extends GrantedAuthority> authorities;

    public JavaCampusUserDetails(AspNetUser user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public AspNetUser getUser() { return user; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override
    public String getPassword() { return user.getPasswordHash(); }

    @Override
    public String getUsername() { return user.getUserName(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return !user.isLockoutEnabled(); }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
