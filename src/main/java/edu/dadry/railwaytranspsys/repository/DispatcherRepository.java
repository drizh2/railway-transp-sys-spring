package edu.dadry.railwaytranspsys.repository;

import edu.dadry.railwaytranspsys.model.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispatcherRepository extends JpaRepository<Dispatcher, Long> {
    Optional<Dispatcher> findById(long id);

    @Query("SELECT d FROM Dispatcher d WHERE d.name LIKE :filter")
    List<Dispatcher> findByFilter(@Param("filter") String filter);
}