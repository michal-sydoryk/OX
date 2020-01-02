package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.board.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RightDownDiagonalCheckerTest {
    private static final Sign signForTests = Sign.CROSS;
    private static final int boardSize = 30;
    private static final int combinationSize = 5;
    private static final int x = 15;
    private static final int y = 15;

    @DataProvider
    public Object[][] diagonalRightDownCornerWiningCombinationsFarawayFromBorder(){
        Board board;
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


    @Test(dataProvider = "diagonalRightDownCornerWiningCombinationsFarawayFromBorder")
    public void shouldReturnTrueIfThereIsDiagonalRightDownWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        UnitChecker rightDownDiagonalChecker = new RightDownDiagonalChecker();
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean result = rightDownDiagonalChecker.check(boardToCheck, coordinatesToCheck);
        //Then
        Assert.assertTrue(result);
    }
}

