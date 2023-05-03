package com.project.cosmetics_store.models;


import javax.persistence.*;

/**
 * class for basket entity
 * @author Vasilisa Murunova
 */
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_count")
    private int itemCount;


    @Column(name = "item_size")
    private String itemSize;

    /**
     * Empty constructor of basket
     */
    public Basket() {
    }

    /**
     * getter method for id of basket entity
     * @return id of basket entity
     */
    public int getId() {
        return id;
    }

    /**
     * setter method for id of basket entity
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for id of user
     * @return user id
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
     * @return item id
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
     * getter method for amount of same items in user basket
     * @return amount of same items in user basket
     */
    public int getItemCount() {
        return itemCount;
    }
    /**
     * setter method for amount of same items in user basket
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * method to stringify info about basket
     * @return info about basket
     */
    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", itemCount=" + itemCount +
                '}';
    }
}
