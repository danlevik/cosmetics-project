package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface for interacting with item table
 * @author Natalia Tuchina
 */
public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findById(int id);
    Long deleteById(int id);
}
