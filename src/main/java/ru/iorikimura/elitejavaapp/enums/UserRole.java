package ru.iorikimura.elitejavaapp.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER,
    ADMIN,
    EVENT_OWNER;

    // Заготовка на будущий Spring Security
    @Override
    public String getAuthority(){
        return this.name();
    }
}
