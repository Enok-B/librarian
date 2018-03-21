package com.enokb.librarian.enums;

public enum UserRoles {
    ADMIN(10, "ROLE_ADMIN"), USER(20, "ROLE_USER");

    private int id;
    private String name;

    UserRoles(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserRoles fromId(int id) {
        for (UserRoles userRoles : UserRoles.values()) {
            if (userRoles.getId() == id) {
                return userRoles;
            }
        }
        return null;
    }
}
