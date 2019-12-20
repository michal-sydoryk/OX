package com.michalsydoryk.app.board;

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


    public void canAddField(){
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        Sign signAdded = board.fields.get(coordinates); //to not use getSignFromField
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not add field!");
    }

    public void shouldReturnTrueWhenTryToAddInEmptyField(){
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        boolean addingResult = board.addField(coordinates, xSign);
        //Then
        Assert.assertTrue(addingResult,"Can not add field!");
    }



    public void shouldReturnFalseWhenTryToAddFieldOutOfBoard(){
        //Given
        int boardSize = 100;
        board = new Board2D(boardSize);
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //when
        boolean addingResult = board.addField(coordinates, xSign);
        //then
        Assert.assertFalse(addingResult, "Can add sign out of border!");
    }


    public void shouldReturnFalseWhenTryToAddInNotEmptyField(){
        //Given
        createNewBoard();
        int x = 102;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        boolean addingResult = board.addField(coordinates, xSign);
        //then
        Assert.assertFalse(addingResult, "Can add sign in not empty field!");

    }

    public void canGetValueFormNotEmptyField(){
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


    public void shouldReturnSignEMPTYWhenTryToGetFieldOutOfBorder(){
        //Given
        int boardSize = 5;
        board = new Board2D(boardSize);
        int x = 6;
        int y = 7;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        //When
        Sign resultSign = board.getSignFromField(coordinates);
        //then
        Assert.assertEquals(resultSign, Sign.EMPTY, "Can get value from field out of border!");
    }

    public void shouldReturnSignEMPTYWhenTryToGetEmptyField(){
        //Given
        createNewBoard();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        //When
        Sign resultSign = board.getSignFromField(coordinates);
        //then
        Assert.assertEquals(resultSign, Sign.EMPTY, "Can get value from field out of border!");
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
    public void shouldBeTrueIfQueueContainsAllAddedFieldToBoard(){
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
