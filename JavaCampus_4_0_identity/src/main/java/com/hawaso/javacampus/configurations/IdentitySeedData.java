package com.hawaso.javacampus.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hawaso.javacampus.services.identity.IdentityService;

@Configuration
public class IdentitySeedData {
    private static final Logger log = LoggerFactory.getLogger(IdentitySeedData.class);

    @Bean
    CommandLineRunner seedIdentityData(IdentityService identityService) {
        return args -> {
            identityService.ensureRoleExists(IdentityService.ROLE_ADMINISTRATORS);
            identityService.ensureRoleExists(IdentityService.ROLE_USERS);

            var admin = identityService.createUser(
                "Administrator",
                "administrator@javacampus.local",
                "기본 관리자",
                "Pa$$w0rd",
                IdentityService.ROLE_ADMINISTRATORS);
            identityService.addUserToRole(admin.getId(), IdentityService.ROLE_USERS);

            log.info("Identity roles and default administrator are ready.");
        };
    }
}
