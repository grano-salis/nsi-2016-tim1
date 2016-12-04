package org.nsi.alpha.services.impl;

import org.nsi.alpha.models.Status;
import org.nsi.alpha.repositories.StatusRepository;
import org.nsi.alpha.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public Status findById(Long id) {
        return statusRepository.findOne(id);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }
}
