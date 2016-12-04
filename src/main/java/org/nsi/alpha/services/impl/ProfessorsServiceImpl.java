package org.nsi.alpha.services.impl;

import org.nsi.alpha.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nsi.alpha.repositories.ProfessorsRepository;
import org.nsi.alpha.services.ProfessorsService;

import java.util.List;

@Service
public class ProfessorsServiceImpl implements ProfessorsService{

    @Autowired
    ProfessorsRepository professorsRepository;

    @Override
    public Professor findById(Long id) {
        return professorsRepository.findOne(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorsRepository.findAll();
    }

    @Override
    public Professor save(Professor professor) {
        return professorsRepository.save(professor);
    }
}
