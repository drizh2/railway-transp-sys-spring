package edu.dadry.railwaytranspsys.controller;

import edu.dadry.railwaytranspsys.payload.request.CreateCustomerRequest;
import edu.dadry.railwaytranspsys.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public String getCustomers() {
        return "customerCreation";
    }

    @PostMapping
    public String addCustomer(CreateCustomerRequest request) {
        customerService.createCustomer(request);

        return "redirect:/home";
    }
}
