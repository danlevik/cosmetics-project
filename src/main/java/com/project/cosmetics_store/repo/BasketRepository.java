package com.project.cosmetics_store.repo;

import com.project.cosmetics_store.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * interface for interacting with basket table
 * @author Vasilisa Murunova
 */
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Basket findByUserIdAndItemId(int userId, int itemId);

    List<Basket> findAllByUserId(int userId);

    Basket findById(int id);

    Long deleteById(int id);

    @Transactional
    Long deleteAllByUserId(int userId);
}
