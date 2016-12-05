package org.nsi.alpha.services;

import org.nsi.alpha.models.Cv;

import java.util.List;

public interface CvService {
    Cv findById(Long id);

    List<Cv> findAll();

    Cv save(Cv cv);

    void remove(Long id);
}
