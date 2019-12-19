package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.FieldIsNotEmptyException;
import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;

@Test
public class Board2DTest {
    private Board2D board;
    private Queue<Coordinates2D> coordinatesQueue = new ArrayDeque<>();

    @BeforeTest
    private void createBoard(){
        board = new Board2D();
    }
    @AfterTest
    private void setBoardToNull(){
        board = null;
    }

    public void shouldBeTrueIfCoordinatesAreInBord() {
        //Given
        int boardSize = 105;
        board = new Board2D(boardSize);
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //when
        boolean inRangeResult = board.coordinatesInBoardSize(coordinates);
        Assert.assertTrue(inRangeResult);
    }


    public void canAddField() {
        //Given
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        try {
            board.addField(coordinates, xSign);
        } catch (OutOfBoardBorderException | FieldIsNotEmptyException e) {
            e.printStackTrace();
        }
        //only for get fields without getter
        Sign signAdded = board.fields.get(coordinates);
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not add field!");
    }


    @Test(expectedExceptions = OutOfBoardBorderException.class)
    public void shouldThrowOutOfBoardException() throws OutOfBoardBorderException, FieldIsNotEmptyException {
        //Given
        int boardSize = 100;
        board = new Board2D(boardSize);
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //when
        board.addField(coordinates, xSign);
    }

    @Test(expectedExceptions = FieldIsNotEmptyException.class)
    public void shouldThrowFieldIsNotEmptyException() throws OutOfBoardBorderException, FieldIsNotEmptyException {
        //Given
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        board.addField(coordinates, xSign);
        //Then
    }

    public void canGetFieldValue(){
        //Given
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        try {
            board.addField(coordinates, xSign);
        } catch (OutOfBoardBorderException | FieldIsNotEmptyException e) {
            e.printStackTrace();
        }
        Sign signFromField = board.getSignFromField(coordinates);
        //Then
        Assert.assertEquals(signFromField, xSign, "Can not get field!");
    }

    @DataProvider
    public static Object[][] coordinatesDataProvider(){
        return new Object[][]{
                {5,4},
                {6,15},
                {1,1},
                {6,16},
                {8,0},
                {5,10},
                {6,60},
                {8,46},
                {1,4},
                {8,4},
                {50,4},
                {45,4},
                {12,4}
        };
    }
/* Ten test jest do zmiany lekkiej
    @Test(dataProvider = "coordinatesDataProvider")
    public void shouldBeTrueIfQueueContainsAllAddedFieldToBoard(int x, int y) {
        //Given
        Coordinates2D coordinates = new Coordinates2D(x,y);
        Sign xSign = Sign.CROSS;
        coordinatesQueue.add(coordinates);
        try {
            board.addField(coordinates, xSign);
        } catch (OutOfBoardBorderException | FieldIsNotEmptyException e) {
            e.printStackTrace();
        }
        }
        //When
        Queue<Coordinates2D> que
        //Then
        Assert.assertTrue();
    } */
}
