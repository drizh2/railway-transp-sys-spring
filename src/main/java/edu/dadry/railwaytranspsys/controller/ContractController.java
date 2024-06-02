package edu.dadry.railwaytranspsys.controller;

import edu.dadry.railwaytranspsys.dao.ContractDAO;
import edu.dadry.railwaytranspsys.dao.CustomerDAO;
import edu.dadry.railwaytranspsys.dao.DispatcherDAO;
import edu.dadry.railwaytranspsys.model.Contract;
import edu.dadry.railwaytranspsys.model.Customer;
import edu.dadry.railwaytranspsys.model.Dispatcher;
import edu.dadry.railwaytranspsys.model.User;
import edu.dadry.railwaytranspsys.payload.request.CreateContractRequest;
import edu.dadry.railwaytranspsys.service.ContractService;
import edu.dadry.railwaytranspsys.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final CustomerService customerService;
    private final CustomerDAO customerDAO;
    private final DispatcherDAO dispatcherDAO;
    private final ContractService contractService;
    private final ContractDAO contractDAO;

    @GetMapping("/{contractId}/customer")
    public String getAddCustomer(@PathVariable String contractId,
                                 @RequestParam(required = false, defaultValue = "") String filter,
                                 Model model) {
        model.addAttribute("contractId", contractId);
        List<Customer> customers = customerDAO.getAllCustomersWithFilter(filter);
        model.addAttribute("customers", customers);
        model.addAttribute("filter", filter);

        return "contractCustomerAddition";
    }

    @PostMapping("/{contractId}/customer")
    public String addCustomer(@PathVariable Long contractId,
                              Long customerId) {
        contractService.addCustomer(contractId, customerId);
        return "redirect:/contract/" + contractId + "/dispatcher";
    }

    @GetMapping("/{contractId}/dispatcher")
    public String getAddDispatcher(@PathVariable String contractId,
                                   @RequestParam(required = false, defaultValue = "") String filter,
                                 Model model) {
        model.addAttribute("contractId", contractId);
        List<Dispatcher> dispatchers = dispatcherDAO.getAllDispatchersByFilter(filter);
        model.addAttribute("dispatchers", dispatchers);
        model.addAttribute("filter", filter);

        return "contractDispatcherAddition";
    }

    @PostMapping("/{contractId}/dispatcher")
    public String addDispatcher(@PathVariable Long contractId,
                              Long dispatcherId) {
        contractService.addDispatcher(contractId, dispatcherId);
        return "redirect:/contract/" + contractId + "/contract";
    }

    @GetMapping("/{contractId}/contract")
    public String getContract(@PathVariable String contractId,
                              Model model) {
        model.addAttribute("contractId", contractId);

        return "contract";
    }

    @PostMapping("/{contractId}/contract")
    public String addContract(@PathVariable Long contractId,
                              CreateContractRequest request) {
        contractService.addInfo(contractId, request);
        return "redirect:/home";
    }

    @PostMapping
    public String createEmptyContract(@AuthenticationPrincipal User user) {
        List<Customer> customers = customerDAO.getAllCustomers();
        if (customers.isEmpty()) {
            return "redirect:/home?error=no_customer";
        }

        List<Dispatcher> dispatchers = dispatcherDAO.getAllDispatchers();
        if (dispatchers.isEmpty()) {
            return "redirect:/home?error=no_dispatcher";
        }

        Contract contract = contractService.createEmptyContract(user);
        return "redirect:/contract/" + contract.getId() + "/customer";
    }

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("contracts", contractDAO.getAllContractsForUser(user));

        return "userContracts";
    }

    @GetMapping("/{contractId}")
    public String getContract(@PathVariable Long contractId, Model model) {
        Contract contract = contractDAO.getContractById(contractId);
        model.addAttribute("contract", contract);
        model.addAttribute("contractId", contractId);

        return "contractEdit";
    }

    @GetMapping("/{contractId}/editContractInfo")
    public String getEditContractInfo(@PathVariable Long contractId, Model model) {
        model.addAttribute("contractId", contractId);
        model.addAttribute("contractInfo", contractDAO.getContractById(contractId));
        return "editContractInfo";
    }

    @GetMapping("/{contractId}/editContractCustomer")
    public String getEditContractCustomer(@PathVariable Long contractId,
                                          @RequestParam(required = false, defaultValue = "") String filter,
                                          Model model) {
        model.addAttribute("contractId", contractId);
        List<Customer> customers = customerDAO.getAllCustomersWithFilter(filter);
        model.addAttribute("customers", customers);
        model.addAttribute("filter", filter);

        return "editContractCustomer";
    }

    @GetMapping("/{contractId}/editContractDispatcher")
    public String getEditContractDispatcher(@PathVariable Long contractId,
                                            @RequestParam(required = false, defaultValue = "") String filter,
                                            Model model) {
        model.addAttribute("contractId", contractId);
        List<Dispatcher> dispatchers = dispatcherDAO.getAllDispatchersByFilter(filter);
        model.addAttribute("dispatchers", dispatchers);
        model.addAttribute("filter", filter);

        return "editContractDispatcher";
    }

    @PostMapping("/{contractId}/customerEdit")
    public String editContractCustomer(@PathVariable Long contractId, Long customerId) {
        contractService.addCustomer(contractId, customerId);

        return "redirect:/contract/" + contractId;
    }

    @PostMapping("/{contractId}/dispatcherEdit")
    public String editContractDispatcher(@PathVariable Long contractId, Long dispatcherId) {
        contractService.addDispatcher(contractId, dispatcherId);

        return "redirect:/contract/" + contractId;
    }

    @PostMapping("/{contractId}/infoEdit")
    public String editContractInfo(@PathVariable Long contractId, CreateContractRequest request) {
        contractService.addInfo(contractId, request);

        return "redirect:/contract/" + contractId;
    }
}
