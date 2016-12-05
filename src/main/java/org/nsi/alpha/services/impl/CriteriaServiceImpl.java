package org.nsi.alpha.services.impl;

import org.nsi.alpha.models.Criteria;
import org.nsi.alpha.repositories.CrieteriaRepository;
import org.nsi.alpha.repositories.ProfessorsRepository;
import org.nsi.alpha.services.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    CrieteriaRepository crieteriaRepository;

    @Override
    public Criteria findById(Long id) {
        return crieteriaRepository.findOne(id);
    }

    @Override
    public List<Criteria> findAll() {
        return crieteriaRepository.findAll();
    }

    @Override
    public Criteria save(Criteria criteria) {
        return crieteriaRepository.save(criteria);
    }

    @Override
    public void remove(Long id) {
        crieteriaRepository.delete(id);
    }
}
