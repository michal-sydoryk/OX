package com.michalsydoryk.app.points;

import java.math.BigDecimal;

public class Points {
    public static final int INITIAL_VALUE = 0;
    BigDecimal value;

    public Points() {
        value = new BigDecimal(INITIAL_VALUE);
    }

    public void add(PointsValue pointsValue){
        value = value.add(pointsValue.getValue());
    }

    public BigDecimal getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "Points: " + value;
    }
}
