package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
