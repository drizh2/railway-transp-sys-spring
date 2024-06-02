package edu.dadry.railwaytranspsys.controller;

import edu.dadry.railwaytranspsys.payload.request.CreateDispatcherRequest;
import edu.dadry.railwaytranspsys.service.DispatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dispatcher")
@RequiredArgsConstructor
public class DispatcherController {

    private final DispatcherService dispatcherService;

    @GetMapping
    public String getDispatcher() {
        return "dispatcherCreation";
    }

    @PostMapping
    public String addDispatcher(CreateDispatcherRequest request) {
        dispatcherService.createDispatcher(request);

        return "redirect:/home";
    }
}
