package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.FieldIsEmptyException;
import com.michalsydoryk.app.board.exception.FieldIsNotEmptyException;
import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

@Test
public class Board2DTest {
    private Board2D board;

    private void createNewBoard(){
        board = new Board2D();
    }

    public void shouldBeTrueIfCoordinatesAreInBord() {
        //Given
        createNewBoard();
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


    public void canAddField() throws OutOfBoardBorderException, FieldIsNotEmptyException {
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        //only for get fields without getter
        Sign signAdded = board.fields.get(coordinates);
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not add field!");
    }


    @Test(expectedExceptions = OutOfBoardBorderException.class)
    public void shouldThrowOutOfBoardExceptionWhenTryToAddFieldOutOfBoard() throws OutOfBoardBorderException, FieldIsNotEmptyException {
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
    public void shouldThrowFieldIsNotEmptyExceptionWhenTryToAddInNotEmptyField() throws OutOfBoardBorderException, FieldIsNotEmptyException {
        //Given
        createNewBoard();
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        board.addField(coordinates, xSign);
    }

    public void canGetValueFormNotEmptyField() throws OutOfBoardBorderException, FieldIsNotEmptyException, FieldIsEmptyException {
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        Sign signFromField = board.getSignFromField(coordinates);
        //Then
        Assert.assertEquals(signFromField, xSign, "Can not get field!");
    }

    @Test(expectedExceptions = OutOfBoardBorderException.class)
    public void shouldThrowOutOfBoardBorderExceptionWhenTryToFieldOutOfBorder() throws OutOfBoardBorderException, FieldIsEmptyException {
        //Given
        int boardSize = 5;
        board = new Board2D(boardSize);
        int x = 6;
        int y = 7;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        //When
        board.getSignFromField(coordinates);
    }

    @Test(expectedExceptions = FieldIsEmptyException.class)
    public void shouldThrowFieldIsEmptyExceptionWhenTryToGetEmptyField() throws OutOfBoardBorderException, FieldIsEmptyException {
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        //When
        board.getSignFromField(coordinates);
    }



    private Set<Coordinates2D> prepareSetToCompare(){
        Set<Coordinates2D> queue = new HashSet<>();
        queue.add(new Coordinates2D(11,4));
        queue.add(new Coordinates2D(1,6));
        queue.add(new Coordinates2D(0,7));
        queue.add(new Coordinates2D(4,9));
        queue.add(new Coordinates2D(16,10));
        queue.add(new Coordinates2D(81,11));
        queue.add(new Coordinates2D(20000,100));
        return queue;
    }

    @Test
    public void shouldBeTrueIfQueueContainsAllAddedFieldToBoard() throws OutOfBoardBorderException, FieldIsNotEmptyException {
        //Given
        createNewBoard();
        Set<Coordinates2D> set = prepareSetToCompare();
        Sign xSign = Sign.CROSS;

        for(Coordinates2D coordinates: set) {
            board.addField(coordinates, xSign);
        }
        //When
        boolean containsAllResult = board.getAllCoordinates().containsAll(set);
        //Then
        Assert.assertTrue(containsAllResult, "Board doesn't contains all added elements!");
    }

}
