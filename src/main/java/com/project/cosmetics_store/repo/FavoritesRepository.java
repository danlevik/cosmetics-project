package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * interface for interacting with favorites table
 * @author Vasilisa Murunova
 */
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {

    Favorites findByUserIdAndItemId(int userId, int itemId);

    List<Favorites> findAllByUserId(int userId);

    Favorites findById(int id);

    Long deleteById(int id);

    @Transactional
    Long deleteAllByUserId(int userId);
}