package com.hawaso.javacampus.controllers.identity;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hawaso.javacampus.models.identity.RegisterInputModel;
import com.hawaso.javacampus.services.identity.IdentityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/Identity/Account")
@SessionAttributes("registerInputModel")
public class AccountController {

    private final IdentityService identityService;

    public AccountController(IdentityService identityService) {
        this.identityService = identityService;
    }

    @GetMapping("/Login")
    public String login(@RequestParam(name = "error", required = false) String error,
                        @RequestParam(name = "logout", required = false) String logout,
                        Principal principal,
                        Model model,
                        HttpServletRequest request) {
        if (principal != null) {
            return "redirect:/";
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            Object authException = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (authException instanceof Exception ex) {
                model.addAttribute("loginErrorMessage", ex.getMessage());
            }
        }

        if (error != null && !model.containsAttribute("loginErrorMessage")) {
            model.addAttribute("loginErrorMessage", "로그인에 실패했습니다. 사용자 이름과 비밀번호를 확인하세요.");
        }
        if (logout != null) {
            model.addAttribute("statusMessage", "로그아웃되었습니다.");
        }
        return "Identity/Account/Login";
    }

    @GetMapping("/Register")
    public String register(Model model) {
        if (!model.containsAttribute("registerInputModel")) {
            model.addAttribute("registerInputModel", new RegisterInputModel());
        }
        return "Identity/Account/Register";
    }

    @PostMapping("/Register")
    public String registerPost(@Valid @ModelAttribute("registerInputModel") RegisterInputModel model,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "Identity/Account/Register";
        }

        try {
            identityService.register(model);
        } catch (IllegalArgumentException ex) {
            bindingResult.reject("register.failed", ex.getMessage());
            return "Identity/Account/Register";
        }

        redirectAttributes.addFlashAttribute("statusMessage", "회원가입이 완료되었습니다. 로그인해 주세요.");
        return "redirect:/Identity/Account/Login";
    }

    @GetMapping("/Manage/Index")
    public String manageIndex(Authentication authentication, Model model) {
        var currentUser = identityService.getCurrentUser(authentication);
        if (currentUser == null) {
            return "redirect:/Identity/Account/Login";
        }
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("currentUserRoles", identityService.getRoleNamesForUser(currentUser.getId()));
        return "Identity/Account/Manage/Index";
    }

    @GetMapping("/AccessDenied")
    public String accessDenied() {
        return "Identity/Account/AccessDenied";
    }
}
