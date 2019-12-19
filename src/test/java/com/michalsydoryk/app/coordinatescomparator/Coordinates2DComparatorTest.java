package com.michalsydoryk.app.coordinatescomparator;

import com.michalsydoryk.app.coordinates.Coordinates2D;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Coordinates2DComparatorTest{
    @DataProvider
    public static Object[][] coordinatesDataProvider(){
        return new Object[][]{
                {5,4,5,4,0}, //equals
                {6,15,6,15,0},
                {1,1,4,4,-1},  //lower Y
                {6,16,15,32,-1},
                {8,0,46,100,-1},
                {5,10,100,4,1},   //bigger Y
                {6,60,88,20,1},
                {8,9,46,0,1},
                {1,4,56,4,-1}, //lower X same Y
                {5,4,8,4,-1},
                {8,4,12,4,-1},
                {50,4,1,4,1},  //bigger x same y
                {45,4,40,4,1},
                {12,4,10,4,1}
        };
    }

    @Test(dataProvider = "coordinatesDataProvider")
    public void compareTests(int x1, int y1, int x2, int y2, int result) {
        //Given
        Coordinates2D coordinates1 = new Coordinates2D(x1, y1);
        Coordinates2D coordinates2 = new Coordinates2D(x2, y2);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = result;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild! Coordinates1: " + coordinates1.toString() + " Coordinates2: " + coordinates2.toString());
    }


}
