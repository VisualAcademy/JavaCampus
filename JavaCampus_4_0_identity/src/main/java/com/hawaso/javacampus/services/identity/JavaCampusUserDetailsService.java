package com.hawaso.javacampus.services.identity;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hawaso.javacampus.models.identity.AspNetRole;
import com.hawaso.javacampus.models.identity.AspNetUser;
import com.hawaso.javacampus.models.identity.AspNetUserRole;
import com.hawaso.javacampus.repositories.identity.AspNetRoleRepository;
import com.hawaso.javacampus.repositories.identity.AspNetUserRepository;
import com.hawaso.javacampus.repositories.identity.AspNetUserRoleRepository;

@Service
public class JavaCampusUserDetailsService implements UserDetailsService {

    private final AspNetUserRepository userRepository;
    private final AspNetUserRoleRepository userRoleRepository;
    private final AspNetRoleRepository roleRepository;

    public JavaCampusUserDetailsService(
        AspNetUserRepository userRepository,
        AspNetUserRoleRepository userRoleRepository,
        AspNetRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String normalizedUserName = IdentityService.normalize(username);
        AspNetUser user = userRepository.findByNormalizedUserName(normalizedUserName)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        List<SimpleGrantedAuthority> authorities = userRoleRepository.findByUserId(user.getId())
            .stream()
            .map(AspNetUserRole::getRoleId)
            .map(roleId -> roleRepository.findById(roleId).orElse(null))
            .filter(role -> role != null && role.getName() != null)
            .map(AspNetRole::getName)
            .map(roleName -> new SimpleGrantedAuthority("ROLE_" + roleName))
            .toList();

        return new JavaCampusUserDetails(user, authorities);
    }
}
