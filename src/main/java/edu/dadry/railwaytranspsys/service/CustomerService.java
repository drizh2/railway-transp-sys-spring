package edu.dadry.railwaytranspsys.service;

import edu.dadry.railwaytranspsys.model.Customer;
import edu.dadry.railwaytranspsys.payload.request.CreateCustomerRequest;
import edu.dadry.railwaytranspsys.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .middlename(request.getMiddlename())
                .company(request.getCompany())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();

        return customerRepository.save(customer);
    }
}
