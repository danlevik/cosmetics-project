package com.project.cosmetics_store.service;

import com.project.cosmetics_store.models.Type;
import com.project.cosmetics_store.repo.TypeRepository;
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
public class TypeService {

    private TypeRepository typeRepo;

    @Autowired
    public TypeService( TypeRepository typeRepo){
        this.typeRepo = typeRepo;
    }

    public Type getTypeById(int id){
        return typeRepo.findById(id);
    }

    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    public void saveType(Type type) {
        typeRepo.save(type);
    }

    public void deleteTypeById(int id) {
        typeRepo.deleteById(id);
    }
}
