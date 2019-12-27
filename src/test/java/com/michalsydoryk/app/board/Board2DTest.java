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

    public void shouldBeTrueIfCoordinatesAreInBord() {
        //Given
        int boardSize = 105;
        Board2D board = new Board2D.Builder().boardSize(boardSize).build();
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
        Board2D board = new Board2D.Builder().build(); //variable board is type board2D
                                                       // because, to not use getSignFromField()
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign xSign = Sign.CROSS;
        //When
        board.addField(coordinates, xSign);
        Sign signAdded = board.fields.get(coordinates);
        //Then
        Assert.assertEquals(signAdded, xSign, "Can not add field!");
    }

    public void shouldReturnTrueWhenTryToAddInEmptyField(){
        //Given
        Board board = new Board2D.Builder().build();
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
        Board board = new Board2D.Builder().boardSize(boardSize).build();
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
        Board board = new Board2D.Builder().build();
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
        Board board = new Board2D.Builder().build();
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
        Board board = new Board2D.Builder().boardSize(boardSize).build();
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
        Board board = new Board2D.Builder().build();
        int x = 1;
        int y = 2;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        //When
        Sign resultSign = board.getSignFromField(coordinates);
        //then
        Assert.assertEquals(resultSign, Sign.EMPTY, "Can get value from field out of border!");
    }



    private Set<Coordinates2D> prepareSetToCompare(){
        Set<Coordinates2D> set = new HashSet<>();
        set.add(new Coordinates2D(11,4));
        set.add(new Coordinates2D(1,6));
        set.add(new Coordinates2D(0,7));
        set.add(new Coordinates2D(4,9));
        set.add(new Coordinates2D(16,10));
        set.add(new Coordinates2D(81,11));
        set.add(new Coordinates2D(20000,100));
        return set;
    }

    public void shouldBeTrueIfQueueContainsAllAddedFieldToBoard(){
        //Given
        Board board = new Board2D.Builder().build();
        Set<Coordinates2D> set = prepareSetToCompare();
        Sign xSign = Sign.CROSS;

        for(Coordinates2D coordinates: set) {
            board.addField(coordinates, xSign);
        }
        //When
        System.out.println(set);
        System.out.println(board.getAllCoordinates());
        boolean containsAllResult = board.getAllCoordinates().containsAll(set);
        //Then
        Assert.assertTrue(containsAllResult, "Board doesn't contains all added elements!");
    }

}
