package com.michalsydoryk.app.points;

import java.math.BigDecimal;

public class Points {
    BigDecimal points;

    public Points() {
        points = new BigDecimal(0);
    }

    void add(PointsValue pointsValue){
        points.add(pointsValue.getValue());
    }

    public BigDecimal getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Points: " + points;
    }
}
