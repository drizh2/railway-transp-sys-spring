package edu.dadry.railwaytranspsys.controller;

import edu.dadry.railwaytranspsys.dao.UserDAO;
import edu.dadry.railwaytranspsys.model.User;
import edu.dadry.railwaytranspsys.model.enums.ERoles;
import edu.dadry.railwaytranspsys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDAO userDAO;
    private final UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userDAO.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(
            @PathVariable User user,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("roles", ERoles.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {

        userService.saveUser(user, username, form);

        return "redirect:/user";
    }
}
