package com.vccaplication.vccapplication.enums;

public enum AppointmentType {
    EMERGENCY("Emergency"),
    CHECK_UP("Check up");

    private final String value;

    AppointmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
