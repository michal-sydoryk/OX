package com.michalsydoryk.app.points;

import java.math.BigDecimal;

public enum PointsValue {
    WIN(30),
    DRAW(10),
    LOSE(3);

    BigDecimal value;

    PointsValue(int value) {
        BigDecimal tempValue = new BigDecimal(0);
        tempValue.add(new BigDecimal(value));
        tempValue.divide(new BigDecimal(10));
        this.value = tempValue;
    }

    PointsValue(double value) {
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
