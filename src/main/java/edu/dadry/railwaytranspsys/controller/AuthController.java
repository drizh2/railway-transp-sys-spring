package edu.dadry.railwaytranspsys.controller;

import edu.dadry.railwaytranspsys.payload.request.CreateUserRequest;
import edu.dadry.railwaytranspsys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping(
            path = "/register")
    public String signup(CreateUserRequest request) {
        userService.createUser(request);

        return "redirect:/signin";
    }
}
