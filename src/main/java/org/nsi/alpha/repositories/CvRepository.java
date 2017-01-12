package org.nsi.alpha.repositories;

import org.nsi.alpha.models.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CvRepository extends JpaRepository<Cv, Long>,
        CrudRepository<Cv, Long> {

        Cv findByUsername(String username);
}
