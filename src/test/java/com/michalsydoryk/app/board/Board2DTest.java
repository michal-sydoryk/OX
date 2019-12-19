package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Board2DTest {
    private Board2D board;

    @BeforeTest
    private void createBoard(){
        board = new Board2D();
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
        } catch (OutOfBoardBorderException e) {
            e.printStackTrace();
        }
        Board2D board2D = (Board2D)board; //only for get fields without getter
        Sign signAdded = board2D.fields.get(coordinates);
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not add field!");
    }


    @Test(expectedExceptions = OutOfBoardBorderException.class)
    public void shouldThrowOutOfBoardException() throws OutOfBoardBorderException {
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



    /*
    public void canGetFieldValue(){
        //Given
        int x = 1;
        int y = 2;
        Coordinates coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        Board2D board2D = (Board2D)board; //only for get fields without getter
        Sign signAdded = board2D.fields.get(coordinates);
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not get field!");
    }
     */
}
