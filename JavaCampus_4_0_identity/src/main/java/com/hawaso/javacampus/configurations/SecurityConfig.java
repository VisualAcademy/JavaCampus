package com.hawaso.javacampus.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hawaso.javacampus.services.identity.JavaCampusUserDetailsService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", "/about", "/services", "/contact", "/prices", "/pricing", "/portfolio", "/portfolios",
                    "/guide", "/help/**", "/pages/**", "/faq", "/playlist", "/techlist", "/errata",
                    "/greeting/**", "/ideas/**", "/Demos/**", "/demo/**", "/api/**", "/css/**", "/js/**",
                    "/images/**", "/Portfolios/**", "/h2/**", "/springboothelloworld", "/SpringBootHelloWorld.html",
                    "/Identity/Account/Login", "/Identity/Account/Register", "/error")
                .permitAll()
                .requestMatchers("/Dashboard/**", "/Administrations/**").hasRole("Administrators")
                .requestMatchers("/Identity/Account/Manage/**").authenticated()
                .anyRequest().permitAll())
            .formLogin(form -> form
                .loginPage("/Identity/Account/Login")
                .loginProcessingUrl("/Identity/Account/Login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/Identity/Account/Login?error=true")
                .permitAll())
            .logout(logout -> logout
                .logoutUrl("/Identity/Account/Logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .permitAll())
            .exceptionHandling(ex -> ex.accessDeniedPage("/Identity/Account/AccessDenied"))
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
            .csrf(csrf -> csrf.disable())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(JavaCampusUserDetailsService userDetailsService,
                                                             PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
