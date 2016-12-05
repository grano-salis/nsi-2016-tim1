package org.nsi.alpha.repositories;

import org.nsi.alpha.models.CvItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CvItemRepository extends JpaRepository<CvItem, Long>,
        CrudRepository<CvItem, Long> {
}
