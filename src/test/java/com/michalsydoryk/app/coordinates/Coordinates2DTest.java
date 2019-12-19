package com.michalsydoryk.app.coordinates;

import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.ITestNGListenerFactory;
import org.testng.ITestNGMethod;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

public class Coordinates2DTest {
    @Test
    public void shouldReturnTrueIfEquals() {
        //Given
        int x = 1;
        int y = 5;
        Coordinates2D coordinates1 = new Coordinates2D(x, y);
        Coordinates2D coordinates2 = new Coordinates2D(x, y);
        //When
        boolean equalsResult = coordinates1.equals(coordinates2);
        //Then
        Assert.assertTrue(equalsResult, "Object are not equals");
    }

    @Test
    public void shouldReturnFalseIfNotEqualsWithSameX(){
        //Given
        int x1 = 4;
        int x2 = 5;
        int y = 0;
        Coordinates2D coordinates1 = new Coordinates2D(x1, y);
        Coordinates2D coordinates2 = new Coordinates2D(x2, y);
        //When
        boolean equalsResult = coordinates1.equals(coordinates2);
        //Then
        Assert.assertFalse(equalsResult,"Object are Equals");
    }

    @Test
    public void shouldReturnFalseIfNotEqualsWithSameY(){
        //Given
        int x = 4;
        int y1 = 5;
        int y2 = 0;
        Coordinates2D coordinates1 = new Coordinates2D(x, y1);
        Coordinates2D coordinates2 = new Coordinates2D(x, y2);
        //When
        boolean equalsResult = coordinates1.equals(coordinates2);
        //Then
        Assert.assertFalse(equalsResult,"Object are Equals");
    }

    @Test
    public void shouldReturnFalseIfNotEqualsWithDiffrentXY(){
        //Given
        int x1 = 4;
        int x2 = 5;
        int y1 = 0;
        int y2 = 68;
        Coordinates2D coordinates1 = new Coordinates2D(x1, y1);
        Coordinates2D coordinates2 = new Coordinates2D(x2, y2);
        //When
        boolean equalsResult = coordinates1.equals(coordinates2);
        //Then
        Assert.assertFalse(equalsResult,"Object are Equals");
    }

}
