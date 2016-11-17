package org.nsi.alpha.repositories;

import org.nsi.alpha.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ekusundzija on 17/11/16.
 */
public interface StatusRepository  extends JpaRepository<Status, Long>,
        CrudRepository<Status, Long> {
}
