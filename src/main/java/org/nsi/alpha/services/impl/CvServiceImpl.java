package org.nsi.alpha.services.impl;

import org.nsi.alpha.models.Cv;
import org.nsi.alpha.repositories.CvRepository;
import org.nsi.alpha.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    CvRepository cvRepository;

    @Override
    public Cv findById(Long id) {
        return cvRepository.findOne(id);
    }

    @Override
    public List<Cv> findAll() {
        return cvRepository.findAll();
    }

    @Override
    public Cv save(Cv cv) {
        return cvRepository.save(cv);
    }

    @Override
    public void remove(Long id) {
        cvRepository.delete(id);
    }
}
