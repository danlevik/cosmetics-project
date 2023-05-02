package com.project.cosmetics_store.service;



import com.project.cosmetics_store.models.Items;
import com.project.cosmetics_store.repo.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesService {

    private ItemsRepository itemsRepository;

    @Autowired
    public ClothesService(ItemsRepository itemsRepository){
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
