package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * interface for interacting with user table
 * @author Natalia Tuchina
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
