package com.project.cosmetics_store.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Class for user entity
 * @author Natalia Tuchina
 */
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username, password;
    private boolean active;

    /**
     * Empty constructor of User
     */
    public User() {
    }

//    @ManyToMany(mappedBy = "subscribers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Clothes> favorites = new HashSet<>();

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated
    private Set<Role> roles;


    /**
     * getter method for id of user
     * @return id of user
     */
    public int getId() {
        return id;
    }
    /**
     * setter method for id of user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for username of user
     * @return username of user
     */
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    /**
     * setter method for username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    /**
     * getter method for password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * setter method for password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter method for active property of user
     * @return active property
     */
    public boolean isActive() {
        return active;
    }
    /**
     * setter method for active property of user
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * getter method for roles of user
     * @return set of user roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * setter method for roles of user
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public Set<Clothes> getFavorites() {
//        return favorites;
//    }
//
//    public void setFavorites(Set<Clothes> favorites) {
//        this.favorites = favorites;
//    }
}
