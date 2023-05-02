package com.project.cosmetics_store.repo;


import com.project.cosmetics_store.models.Items;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Long> {
    List<Items> findAllByTypeId(int typeId);

    List <Items> findAll();


    Items findById(int id);

//    @Override
//    Optional findById(int id);

    Long deleteById(int id);
}
