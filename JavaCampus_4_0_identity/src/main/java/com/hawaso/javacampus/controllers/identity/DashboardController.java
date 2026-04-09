package com.hawaso.javacampus.controllers.identity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hawaso.javacampus.services.identity.IdentityService;

@Controller
public class DashboardController {
    private final IdentityService identityService;

    public DashboardController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @PreAuthorize("hasRole('Administrators')")
    @GetMapping({"/Dashboard", "/Administrations/Dashboard"})
    public String index(Authentication authentication, Model model) {
        var currentUser = identityService.getCurrentUser(authentication);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("currentUserRoles", currentUser == null ? java.util.List.of() : identityService.getRoleNamesForUser(currentUser.getId()));
        return "Admin/Dashboard";
    }
}
