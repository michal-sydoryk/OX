package com.michalsydoryk.app.points;

import java.math.BigDecimal;

public enum PointsValue {
    WIN("3"),
    DRAW("1"),
    LOSE("0.3");

    private BigDecimal value;

    PointsValue(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
