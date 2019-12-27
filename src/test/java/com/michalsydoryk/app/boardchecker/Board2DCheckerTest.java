package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class Board2DCheckerTest {
    Sign signForTests = Sign.CROSS;

    //--------vertical tests--------
    @DataProvider
    public Object[][] verticalWiningCombinationFarawayFromBorder(){
        int combinationSize = 5;
        int boardSize = 30;
        Board2D board;
        int x = 15;
        int y = 15;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign sign = signForTests;
        Object[][] objects = new Object[combinationSize][2];
        for(int i = 0; i < combinationSize; i++){
            board = new Board2D.Builder().boardSize(boardSize).combinationSize(combinationSize).build();
            for( int j = i; j < combinationSize + i; j++){
                Coordinates2D coordinatesToAdd = new Coordinates2D(x, y + combinationSize -1 - j);
                if(!coordinates.equals(coordinatesToAdd))
                    board.addField(coordinatesToAdd, sign);
            }
            objects[i][0] = board;
            objects[i][1] = coordinates;
        }
        return objects;
    }


    @Test(dataProvider = "verticalWiningCombinationFarawayFromBorder")
    public void shouldReturnTrueIfThereIsVerticalWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        Board2DChecker checker = new Board2DChecker(boardToCheck);
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean check = checker.checkVertical(coordinatesToCheck);
        //Then
        Assert.assertTrue(check);
    }


    //--------horizontal tests--------
    @DataProvider
    public Object[][] horizontalWiningCombinationFarawayFromBorder(){
        int combinationSize = 5;
        int boardSize = 30;
        Board2D board;
        int x = 15;
        int y = 15;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign sign = signForTests;
        Object[][] objects = new Object[combinationSize][2];
        for(int i = 0; i < combinationSize; i++){
            board = new Board2D.Builder().boardSize(boardSize).combinationSize(combinationSize).build();
            for( int j = i; j < combinationSize + i; j++){
                Coordinates2D coordinatesToAdd = new Coordinates2D(x + combinationSize -1 - j, y);
                if(!coordinates.equals(coordinatesToAdd))
                    board.addField(coordinatesToAdd, sign);
            }
            objects[i][0] = board;
            objects[i][1] = coordinates;
        }
        return objects;
    }


    @Test(dataProvider = "horizontalWiningCombinationFarawayFromBorder")
    public void shouldReturnTrueIfThereIsHorizontalWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        Board2DChecker checker = new Board2DChecker(boardToCheck);
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean check = checker.checkHorizontal(coordinatesToCheck);
        //Then
        Assert.assertTrue(check);
    }

    //--------diagonal form left up tests--------
    @DataProvider
    public Object[][] diagonalFromLeftUpCornerWiningCombinationFarawayFromBorder(){
        int combinationSize = 5;
        int boardSize = 30;
        Board2D board;
        int x = 15;
        int y = 15;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign sign = signForTests;
        Object[][] objects = new Object[combinationSize][2];
        for(int i = 0; i < combinationSize; i++){
            board = new Board2D.Builder().boardSize(boardSize).combinationSize(combinationSize).build();
            for( int j = i; j < combinationSize + i; j++){
                Coordinates2D coordinatesToAdd = new Coordinates2D(x + combinationSize -1 - j, y  + combinationSize -1 - j);
                if(!coordinates.equals(coordinatesToAdd))
                    board.addField(coordinatesToAdd, sign);
            }
            objects[i][0] = board;
            objects[i][1] = coordinates;
        }
        return objects;
    }


    @Test(dataProvider = "diagonalFromLeftUpCornerWiningCombinationFarawayFromBorder")
    public void shouldReturnTrueIfThereIsDiagonalFromLeftUpCornerWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        Board2DChecker checker = new Board2DChecker(boardToCheck);
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean check = checker.checkDiagonalFromLeftUpCorner(coordinatesToCheck);
        //Then
        Assert.assertTrue(check);
    }

    //--------diagonal form left down tests--------
    @DataProvider
    public Object[][] diagonalFromLeftDownCornerWiningCombinationFarawayFromBorder(){
        int combinationSize = 5;
        int boardSize = 30;
        Board2D board;
        int x = 15;
        int y = 15;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign sign = signForTests;
        Object[][] objects = new Object[combinationSize][2];
        for(int i = 0; i < combinationSize; i++){
            board = new Board2D.Builder().boardSize(boardSize).combinationSize(combinationSize).build();
            for( int j = i; j < combinationSize + i; j++){
                Coordinates2D coordinatesToAdd = new Coordinates2D(x + combinationSize -1 - j, y - (combinationSize -1 - j));
                if(!coordinates.equals(coordinatesToAdd))
                    board.addField(coordinatesToAdd, sign);
            }
            objects[i][0] = board;
            objects[i][1] = coordinates;
        }
        return objects;
    }


    @Test(dataProvider = "diagonalFromLeftDownCornerWiningCombinationFarawayFromBorder")
    public void shouldReturnTrueIfThereIsDiagonalFromLeftDownCornerWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        Board2DChecker checker = new Board2DChecker(boardToCheck);
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean check = checker.checkDiagonalFromLeftDownCorner(coordinatesToCheck);
        //Then
        Assert.assertTrue(check);
    }
}
