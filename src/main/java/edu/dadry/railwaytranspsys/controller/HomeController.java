package edu.dadry.railwaytranspsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            switch (error) {
                case "no_customer": {
                    model.addAttribute("error", "Customer not found");
                    break;
                }
                case "no_dispatcher": {
                    model.addAttribute("error", "Dispatcher not found");
                    break;
                }
                case "no_contract": {
                    model.addAttribute("error", "Contract not found");
                    break;
                }
            }
        }
        return "home";
    }
}
