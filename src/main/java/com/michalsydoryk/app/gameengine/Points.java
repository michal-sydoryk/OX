package com.michalsydoryk.app.gameengine;

import java.math.BigDecimal;
import java.util.Objects;

class Points {
    private final BigDecimal INITIAL_VALUE = BigDecimal.ZERO;
    private BigDecimal value;

    Points() {
        value = INITIAL_VALUE;
    }

    void add(PointsValue pointsValue){
        value = value.add(pointsValue.getValue());
    }

    BigDecimal getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(value, points.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INITIAL_VALUE, value);
    }

    @Override
    public String toString() {
        return "Points: " + value;
    }
}
