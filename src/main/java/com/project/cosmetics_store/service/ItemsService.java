package com.project.cosmetics_store.service;



import com.project.cosmetics_store.models.Items;
import com.project.cosmetics_store.repo.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for interacting with items table of database
 * @author Anastasia Ovcharenko
 */
@Service
@RequiredArgsConstructor
public class ItemsService {

    private ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAllItemsById(){
        return itemsRepository.findAll();
    }

    public List<Items> getAllItemsByTypeId(int typeId) {
        return itemsRepository.findAllByTypeId(typeId);
    }

    public Items getItemById(int id){
        return itemsRepository.findById(id);
    }

    public void saveItem(Items items){
        itemsRepository.save(items);
    }

    public void deleteItemById(int id){
        itemsRepository.deleteById(id);
    }
}
