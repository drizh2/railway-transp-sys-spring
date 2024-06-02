package edu.dadry.railwaytranspsys.repository;

import edu.dadry.railwaytranspsys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);

    @Query("SELECT c FROM Customer c WHERE c.name LIKE :filter")
    List<Customer> findByFilter(@Param("filter") String filter);
}
