package org.nsi.alpha.services;

import org.nsi.alpha.models.CvItem;

import java.util.List;

public interface CvItemService {
    CvItem findById(Long id);

    List<CvItem> findAll();

    CvItem save(CvItem cvItem);

    void remove(Long id);
}
