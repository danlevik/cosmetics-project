package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findById(int id);
    Long deleteById(int id);
}
