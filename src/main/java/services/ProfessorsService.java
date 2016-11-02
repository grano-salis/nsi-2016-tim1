package services;

import models.Professor;

import java.util.List;

/**
 * Created by edenasevic on 11/2/16.
 */

public interface ProfessorsService {
    Professor findById(Long id);
    List<Professor> findAll();
}
