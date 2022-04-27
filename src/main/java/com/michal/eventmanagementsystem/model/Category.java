package com.michal.eventmanagementsystem.model;

public enum Category {
    CINEMA(0),
    THEATRE(1),
    SPORT(2),
    EXHIBITION(3),
    CONFERENCE(4),
    FESTIVAL(5),
    OTHER(6);

    private int categoryValue;

    Category(int value) {
        this.categoryValue = categoryValue;
    }

    public int getCategoryValue() {
        return categoryValue;
    }
}
