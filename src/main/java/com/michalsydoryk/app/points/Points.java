package com.michalsydoryk.app.points;

import java.math.BigDecimal;
import java.util.Objects;

public class Points {

    private final BigDecimal INITIAL_VALUE = BigDecimal.ZERO;
    BigDecimal value;

    public Points() {
        value = INITIAL_VALUE;
    }

    public void add(PointsValue pointsValue){
        value = value.add(pointsValue.getValue());
    }

    public BigDecimal getValue(){
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
