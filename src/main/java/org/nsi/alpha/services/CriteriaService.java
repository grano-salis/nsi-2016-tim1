package org.nsi.alpha.services;

import org.nsi.alpha.models.Criteria;

import java.util.List;

/**
 * Created by ekusundzija on 17/11/16.
 */
public interface CriteriaService {
    Criteria findById(Long id);

    List<Criteria> findAll();

    Criteria save(Criteria criteria);

    void remove(Long id);
}
