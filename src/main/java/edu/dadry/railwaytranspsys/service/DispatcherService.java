package edu.dadry.railwaytranspsys.service;

import edu.dadry.railwaytranspsys.model.Dispatcher;
import edu.dadry.railwaytranspsys.payload.request.CreateDispatcherRequest;
import edu.dadry.railwaytranspsys.repository.DispatcherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispatcherService {
    private final DispatcherRepository dispatcherRepository;

    public Dispatcher createDispatcher(CreateDispatcherRequest request) {
        Dispatcher dispatcher = Dispatcher.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .middlename(request.getMiddlename())
                .company(request.getCompany())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .experience(request.getExperience())
                .build();

        return dispatcherRepository.save(dispatcher);
    }
}