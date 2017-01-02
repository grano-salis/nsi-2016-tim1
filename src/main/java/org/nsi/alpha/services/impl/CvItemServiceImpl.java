package org.nsi.alpha.services.impl;

import org.nsi.alpha.models.CvItem;
import org.nsi.alpha.repositories.CvItemRepository;
import org.nsi.alpha.services.CvItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvItemServiceImpl implements CvItemService {

    @Autowired
    CvItemRepository cvItemRepository;

    @Override
    public CvItem findById(Long id) {
        return cvItemRepository.findOne(id);
    }

    @Override
    public List<CvItem> findAll() {
        return cvItemRepository.findAll();
    }

    @Override
    public CvItem save(CvItem cvItem) {
        return cvItemRepository.save(cvItem);
    }

    @Override
    public void remove(Long id) {
        cvItemRepository.delete(id);
    }

    @Override
    public long count() {
        return cvItemRepository.count();
    }
}
