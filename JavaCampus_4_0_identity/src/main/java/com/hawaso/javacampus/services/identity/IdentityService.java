package com.hawaso.javacampus.services.identity;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hawaso.javacampus.models.identity.AspNetRole;
import com.hawaso.javacampus.models.identity.AspNetUser;
import com.hawaso.javacampus.models.identity.AspNetUserRole;
import com.hawaso.javacampus.models.identity.RegisterInputModel;
import com.hawaso.javacampus.repositories.identity.AspNetRoleRepository;
import com.hawaso.javacampus.repositories.identity.AspNetUserRepository;
import com.hawaso.javacampus.repositories.identity.AspNetUserRoleRepository;

@Service
public class IdentityService {
    public static final String ROLE_ADMINISTRATORS = "Administrators";
    public static final String ROLE_USERS = "Users";

    private final AspNetUserRepository userRepository;
    private final AspNetRoleRepository roleRepository;
    private final AspNetUserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public IdentityService(
        AspNetUserRepository userRepository,
        AspNetRoleRepository roleRepository,
        AspNetUserRoleRepository userRoleRepository,
        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static String normalize(String value) {
        return value == null ? null : value.trim().toUpperCase(Locale.ROOT);
    }

    public Optional<AspNetUser> findByUserName(String userName) {
        return userRepository.findByNormalizedUserName(normalize(userName));
    }

    public AspNetUser getCurrentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return findByUserName(authentication.getName()).orElse(null);
    }

    public List<String> getRoleNamesForUser(String userId) {
        return userRoleRepository.findByUserId(userId).stream()
            .map(AspNetUserRole::getRoleId)
            .map(roleId -> roleRepository.findById(roleId).orElse(null))
            .filter(role -> role != null && role.getName() != null)
            .map(AspNetRole::getName)
            .toList();
    }

    @Transactional
    public void ensureRoleExists(String roleName) {
        String normalizedName = normalize(roleName);
        if (roleRepository.findByNormalizedName(normalizedName).isPresent()) {
            return;
        }
        AspNetRole role = new AspNetRole();
        role.setId(UUID.randomUUID().toString());
        role.setName(roleName);
        role.setNormalizedName(normalizedName);
        role.setConcurrencyStamp(UUID.randomUUID().toString());
        roleRepository.save(role);
    }

    @Transactional
    public AspNetUser createUser(String userName, String email, String displayName, String rawPassword, String roleName) {
        AspNetUser existing = findByUserName(userName).orElse(null);
        if (existing != null) {
            return existing;
        }
        AspNetUser user = new AspNetUser();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setNormalizedUserName(normalize(userName));
        user.setEmail(email);
        user.setNormalizedEmail(normalize(email));
        user.setDisplayName(displayName);
        user.setEmailConfirmed(true);
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        user.setSecurityStamp(UUID.randomUUID().toString());
        user.setConcurrencyStamp(UUID.randomUUID().toString());
        user.setLockoutEnabled(false);
        user.setAccessFailedCount(0);
        AspNetUser saved = userRepository.save(user);
        addUserToRole(saved.getId(), roleName);
        return saved;
    }

    @Transactional
    public void addUserToRole(String userId, String roleName) {
        AspNetRole role = roleRepository.findByNormalizedName(normalize(roleName)).orElseThrow();
        if (!userRoleRepository.existsByUserIdAndRoleId(userId, role.getId())) {
            userRoleRepository.save(new AspNetUserRole(userId, role.getId()));
        }
    }

    @Transactional
    public void register(RegisterInputModel model) {
        if (findByUserName(model.getUserName()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 사용자 이름입니다.");
        }
        if (userRepository.findByNormalizedEmail(normalize(model.getEmail())).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
        createUser(model.getUserName(), model.getEmail(), model.getDisplayName(), model.getPassword(), ROLE_USERS);
    }
}
