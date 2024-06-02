package edu.dadry.railwaytranspsys.dao;

import edu.dadry.railwaytranspsys.model.Contract;
import edu.dadry.railwaytranspsys.model.User;
import edu.dadry.railwaytranspsys.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractDAO {
    private final ContractRepository contractRepository;

    public Contract getContractById(Long contractId) {
        return contractRepository.findById(contractId)
                .orElse(null);
    }

    public List<Contract> getAllContractsForUser(User user) {
        return contractRepository.findAllByUser(user);
    }
}
