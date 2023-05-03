package com.project.cosmetics_store.models;

import javax.persistence.*;

/**
 * Class for items entity
 * @author Anastasia Ovcharenko
 */
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column
    private String coverLink, itemName;
    private int price, typeId;
//    private boolean isRead;

//    public String getShopLink() {
//        return shopLink;
//    }
//
//    public void setShopLink(String shopLink) {
//        this.shopLink = shopLink;
//    }



    /**
     * Empty constructor of Items
     */
    public Items() {
    }

    /**
     * constructor for item
     * @param itemName - name of item
     * @param coverLink - link for cover image
     * @param price - price of item
     * @param typeId - type of item
     */
    public Items(String itemName, String coverLink, int price, int typeId) {
        this.coverLink = coverLink;
        this.itemName = itemName;
        this.price = price;
        this.typeId = typeId;

//        this.isRead = isRead;
//        this.shopLink = shopLink;
    }

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "favorite_books",
//            joinColumns = @JoinColumn(name = "favbook_id"),
//            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
//    )
//    private Set<User> subscribers = new HashSet<>();

    /**
     * getter method for id of item entity
     * @return id of item entity
     */
    public int getId() {
        return id;
    }

    /**
     * setter method for id of item entity
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for price of item
     * @return price of item
     */
    public int getPrice() {
        return price;
    }

    /**
     * getter method for id of type
     * @return id of type
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * setter method for price of item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * setter method for id of type
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * getter method for cover link
     * @return cover link
     */
    public String getCoverLink() {
        return coverLink;
    }
    /**
     * setter method for cover link
     */
    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }

    /**
     * getter method for item name
     * @return item name
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * setter method for item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


//    public boolean isRead() {
//        return isRead;
//    }
//
//    public void setRead(boolean read) {
//        isRead = read;
//    }

//    public Set<User> getSubscribers() {
//        return subscribers;
//    }
//
//    public void setSubscribers(Set<User> subscribers) {
//        this.subscribers = subscribers;
//    }
}
