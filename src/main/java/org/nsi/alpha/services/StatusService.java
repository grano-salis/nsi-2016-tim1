package org.nsi.alpha.services;

import org.nsi.alpha.models.Status;

import java.util.List;

/**
 * Created by ekusundzija on 17/11/16.
 */
public interface StatusService {
    Status findById(Long id);
    List<Status> findAll();
    Status save(Status status);
}
