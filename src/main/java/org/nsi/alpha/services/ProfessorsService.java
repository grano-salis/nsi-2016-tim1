package org.nsi.alpha.services;

import org.nsi.alpha.models.Professor;

import java.util.List;

/**
 * Created by edenasevic on 11/2/16.
 */

public interface ProfessorsService {
    Professor findById(Long id);
    List<Professor> findAll();
    Professor save(Professor professor2);
}
