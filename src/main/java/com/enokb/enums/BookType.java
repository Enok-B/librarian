package com.enokb.enums;

public enum BookType {
    EDUCATION(0), NOVEL(1), ART(2), TECHNOLOGY(3);

    private int type;

    BookType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static BookType getType(int type) {
        for (BookType bookType : values()) {
            if (bookType.getType() == type) {
                return bookType;
            }
        }
        return null;
    }
}
