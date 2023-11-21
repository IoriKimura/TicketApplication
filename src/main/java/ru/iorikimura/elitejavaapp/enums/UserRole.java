package ru.iorikimura.elitejavaapp.enums;

public enum UserRole {
    USER,
    ADMIN,
    EVENT_OWNER;

    // Заготовка на будущий Spring Security
//    @Override
//    public String getAuthority(){
//        return this.name();
//    }
}
