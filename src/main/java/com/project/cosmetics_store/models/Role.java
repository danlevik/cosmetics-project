package com.project.cosmetics_store.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Class for role entity
 * @author Natalia Tuchina
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    /**
     * overriding method for receiving name of role from getAuthority method
     * @return role name
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
