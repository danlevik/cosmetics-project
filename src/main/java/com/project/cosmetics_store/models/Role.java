package com.project.cosmetics_store.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Class for role entity
 * @author Natalia Tuchina
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
