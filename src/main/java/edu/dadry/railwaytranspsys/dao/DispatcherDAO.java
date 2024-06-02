package edu.dadry.railwaytranspsys.dao;

import edu.dadry.railwaytranspsys.model.Dispatcher;
import edu.dadry.railwaytranspsys.repository.DispatcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DispatcherDAO {
    private final DispatcherRepository dispatcherRepository;

    public List<Dispatcher> getAllDispatchers() {
        return dispatcherRepository.findAll();
    }

    public Dispatcher getDispatcherById(Long id) {
        return dispatcherRepository.findById(id)
                .orElse(null);
    }

    public List<Dispatcher> getAllDispatchersByFilter(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return dispatcherRepository.findByFilter(filter);
        } else {
            return dispatcherRepository.findAll();
        }
    }
}
