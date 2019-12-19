package com.michalsydoryk.app.coordinatescomparator;

import com.michalsydoryk.app.coordinates.Coordinates;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Coordinates2DComparatorTest{
    @Test
    public void shouldReturn0IfCoordinatesAreEquals() {
        //Given
        int x = 1;
        int y = 2;
        Coordinates coordinates1 = new Coordinates2D(x, y);
        Coordinates coordinates2 = new Coordinates2D(x, y);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = 0;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }

    @Test
    public void shouldReturnMinus1IfCoordinates1HaveLowerY() {
        //Given
        int x = 1;
        int y1 = 1;
        int y2 = 2;
        Coordinates coordinates1 = new Coordinates2D(x, y1);
        Coordinates coordinates2 = new Coordinates2D(x, y2);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = -1;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }

    @Test
    public void shouldReturn1IfCoordinates1HaveBiggerY() {
        //Given
        int x = 1;
        int y1 = 3;
        int y2 = 2;
        Coordinates coordinates1 = new Coordinates2D(x, y1);
        Coordinates coordinates2 = new Coordinates2D(x, y2);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = 1;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }

    @Test
    public void shouldReturnMinus1IfCoordinates1HaveEqualsYButLowerX() {
        //Given
        int x1 = 1;
        int x2 = 6;
        int y = 2;
        Coordinates coordinates1 = new Coordinates2D(x1, y);
        Coordinates coordinates2 = new Coordinates2D(x2, y);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = -1;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }

    @Test
    public void shouldReturn1IfCoordinates1HaveEqualsYButBiggerX() {
        //Given
        int x1 = 20;
        int x2 = 6;
        int y = 2;
        Coordinates coordinates1 = new Coordinates2D(x1, y);
        Coordinates coordinates2 = new Coordinates2D(x2, y);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = 1;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }

    @Test
    public void shouldReturn0IfCoordinates1HaveEqualsYAndEqualsX() {

        //Given
        int x = 20;
        int y = 2;
        Coordinates coordinates1 = new Coordinates2D(x, y);
        Coordinates coordinates2 = new Coordinates2D(x, y);
        Coordinates2DComparator coordinatesComparator = new Coordinates2DComparator();
        //When
        int compareResult = coordinatesComparator.compare((Coordinates2D)coordinates1, (Coordinates2D)coordinates2);
        int expectedResult = 0;
        //Then
        Assert.assertEquals(compareResult, expectedResult, "Comparation faild");
    }
}
