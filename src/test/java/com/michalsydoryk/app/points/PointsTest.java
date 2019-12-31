package com.michalsydoryk.app.points;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

@Test
public class PointsTest {
    public void shouldReturn4PointsIfPossibilityToAddPointsWINAndDRAW(){
        //given
        Points points = new Points();
        points.add(PointsValue.WIN);
        points.add(PointsValue.DRAW);
        System.out.println(points.toString());
        //when
        BigDecimal result = points.getValue();
        BigDecimal expectedResult = new BigDecimal("4");
        //then
        Assert.assertEquals(result, expectedResult, "Points are not equals!");
    }
}
