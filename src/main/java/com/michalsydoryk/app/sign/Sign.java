package com.michalsydoryk.app.sign;

public enum Sign {
    NAUGHT('O'),
    CROSS('X');

    char value;

    Sign(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
