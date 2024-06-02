package edu.dadry.railwaytranspsys.repository;

import edu.dadry.railwaytranspsys.model.Contract;
import edu.dadry.railwaytranspsys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findById(long id);
    List<Contract> findAllByUser(User user);
}
