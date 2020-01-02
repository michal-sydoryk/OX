package com.michalsydoryk.app.gameengine;

import java.math.BigDecimal;

enum PointsValue {
    WIN("3"),
    DRAW("1");

    private final BigDecimal value;

    PointsValue(String value) {
        this.value = new BigDecimal(value);
    }

    BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
