package services.impl;

import models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProfessorsRepository;
import services.ProfessorsService;

import java.util.List;

/**
 * Created by edenasevic on 11/2/16.
 */

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
}
