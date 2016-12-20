package org.nsi.alpha.repositories;

import org.nsi.alpha.models.CvItem;
import org.nsi.alpha.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ekusundzija on 17/11/16.
 */
public interface StatusRepository  extends JpaRepository<Status, Long>,
        CrudRepository<Status, Long> {

    @Query("SELECT c FROM CvItem c, Status s WHERE c.statusId = s.id AND s.value = :statusValue")
    public List<CvItem> findItemsByStatus(@Param("statusValue") String status);
}
