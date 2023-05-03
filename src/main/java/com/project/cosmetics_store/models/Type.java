package com.project.cosmetics_store.models;

import javax.persistence.*;

/**
 * Class for type entity
 * @author Anastasia Ovcharenko
 */
@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name", nullable = false)
    private String name;

    /**
     * Empty constructor of Type
     */
    public Type() {
    }

    /**
     * getter method for id of type
     * @return id of type
     */
    public int getId() {
        return id;
    }
    /**
     * setter method for id of type
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * getter method for name of type
     * @return name of type
     */
    public String getName() {
        return name;
    }
    /**
     * setter method for name of type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to stringify info about type
     * @return info about type
     */
    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
