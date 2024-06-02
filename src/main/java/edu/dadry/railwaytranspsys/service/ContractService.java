package edu.dadry.railwaytranspsys.service;

import edu.dadry.railwaytranspsys.dao.ContractDAO;
import edu.dadry.railwaytranspsys.dao.CustomerDAO;
import edu.dadry.railwaytranspsys.dao.DispatcherDAO;
import edu.dadry.railwaytranspsys.model.Contract;
import edu.dadry.railwaytranspsys.model.Customer;
import edu.dadry.railwaytranspsys.model.Dispatcher;
import edu.dadry.railwaytranspsys.model.User;
import edu.dadry.railwaytranspsys.payload.request.CreateContractRequest;
import edu.dadry.railwaytranspsys.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ContractDAO contractDAO;
    private final CustomerDAO customerDAO;
    private final DispatcherDAO dispatcherDAO;

    public Contract createEmptyContract(User user) {
        Contract contract = new Contract();
        contract.setUser(user);
        return contractRepository.save(contract);
    }

    public void addCustomer(Long contractId, Long customerId) {
        Contract contract = contractDAO.getContractById(contractId);
        Customer customer = customerDAO.getCustomerById(customerId);

        contract.setCustomer(customer);
        contractRepository.save(contract);
    }

    public void addDispatcher(Long contractId, Long dispatcherId) {
        Contract contract = contractDAO.getContractById(contractId);
        Dispatcher dispatcher = dispatcherDAO.getDispatcherById(dispatcherId);

        contract.setDispatcher(dispatcher);
        contractRepository.save(contract);
    }

    public void addInfo(Long contractId, CreateContractRequest request) {
        Contract contract = contractDAO.getContractById(contractId);
        contract.setSumOfInsurance(request.getSumOfInsurance());
        contract.setTypeOfCargo(request.getTypeOfCargo());
        contract.setTimeToTransport(request.getTimeToTransport());
        contract.setStartStation(request.getStartStation());
        contract.setFinishStation(request.getFinishStation());
        contract.setCost(request.getCost());
        contract.setWeight(request.getWeight());
        contract.setDate(request.getDate());

        contractRepository.save(contract);
    }
}
