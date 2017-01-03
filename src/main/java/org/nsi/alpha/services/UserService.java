package org.nsi.alpha.services;

import org.nsi.alpha.models.User;

public interface UserService {
    User findByUsername(String username);
}
