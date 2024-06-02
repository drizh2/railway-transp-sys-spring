package edu.dadry.railwaytranspsys.dao;

import edu.dadry.railwaytranspsys.model.Customer;
import edu.dadry.railwaytranspsys.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElse(null);
    }

    public List<Customer> getAllCustomersWithFilter(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return customerRepository.findByFilter(filter);
        } else {
            return customerRepository.findAll();
        }
    }
}
