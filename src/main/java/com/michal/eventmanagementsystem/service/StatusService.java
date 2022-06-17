package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.model.Status;
import com.michal.eventmanagementsystem.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    public void save(Status status) {
        if (status.getId() != null) {
            Long id = status.getId();
            statusRepository.findById(id)
                    .ifPresent(status1 -> {
                                status.setId(id);
                                statusRepository.save(status);
                            }
                    );
        } else {
            statusRepository.save(status);
        }
    }

    public void update(Status status) {
        if (status.getId() != null) {
            Long id = status.getId();
            statusRepository.findById(id)
                    .ifPresent(status1 -> {
                                status.setId(id);
                                statusRepository.save(status);
                            }
                    );
        }
    }
}
