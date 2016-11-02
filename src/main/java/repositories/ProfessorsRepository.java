package repositories;

import models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by edenasevic on 11/2/16.
 */

public interface ProfessorsRepository extends JpaRepository<Professor, Long>,
                                              CrudRepository<Professor, Long>{
}
