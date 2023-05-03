package com.project.cosmetics_store.models;

import javax.persistence.*;

/**
 * Class for favorites entity
 * @author Vasilisa Murunova
 */
@Entity
@Table(name = "favs")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int itemId;


    /**
     * Empty constructor of favorites
     */
    public Favorites() {
    }

    /**
     * getter method for id of favorites entity
     * @return id of favorites entity
     */
    public int getId() {
        return id;
    }
    /**
     * setter method for id of favorites entity
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for id of user
     * @return id of user
     */
    public int getUserId() {
        return userId;
    }
    /**
     * setter method for id of user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * getter method for id of item
     * @return id of item
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * setter method for id of item
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * method to stringify info about favorites
     * @return info about favorites
     */
    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                '}';
    }
}
