package com.michalsydoryk.app.points;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

@Test
public class PointsTest {
    public void shouldReturn4Coma3Points(){
        //given
        Points points = new Points();
        points.add(PointsValue.WIN);
        points.add(PointsValue.DRAW);
        points.add(PointsValue.LOSE);
        System.out.println(points.toString());
        //when
        BigDecimal result = points.getPoints();
        BigDecimal expectedResult = new BigDecimal(4.3);
        //then
        Assert.assertEquals(result, expectedResult, "Points are not equals!");
    }
}
