package com.michal.eventmanagementsystem.service;

import com.michal.eventmanagementsystem.dto.StatusDto;
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

    public void save(StatusDto statusDto) {
        if (statusDto.getId() != null) {
            Long id = statusDto.getId();
            statusRepository.findById(id)
                    .ifPresent(status1 -> {
                                statusDto.setId(id);
                                statusRepository.save(statusDto.toStatus());
                            }
                    );
        } else {
            statusRepository.save(statusDto.toStatus());
        }
    }

    public void update(StatusDto statusDto) {
        if (statusDto.getId() != null) {
            Long id = statusDto.getId();
            statusRepository.findById(id)
                    .ifPresent(status1 -> {
                                statusDto.setId(id);
                                statusRepository.save(statusDto.toStatus());
                            }
                    );
        }
    }
}
