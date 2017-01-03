package org.nsi.alpha.repositories;

import org.nsi.alpha.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long>,
        CrudRepository<User, Long> {
    User findByUsername(String username);
}
