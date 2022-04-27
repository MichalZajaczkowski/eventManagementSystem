package com.michal.eventmanagementsystem.model;

public enum Status {
    ACTIVE(0),
    INACTIVE(1),
    TOACTIVETE(2),
    CLOSED(3);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
