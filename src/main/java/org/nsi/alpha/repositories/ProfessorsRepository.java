package org.nsi.alpha.repositories;

import org.nsi.alpha.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edenasevic on 11/2/16.
 */

public interface ProfessorsRepository extends JpaRepository<Professor, Long>,
                                              CrudRepository<Professor, Long>{
}
