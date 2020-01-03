package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.board.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class HorizontalCheckerTest {
    private static final Sign signForTests = Sign.CROSS;
    private static final int boardSize = 30;
    private static final int combinationSize = 5;
    private static final int x = 15;
    private static final int y = 15;

    @DataProvider
    public Object[][] horizontalWiningCombinationsFarawayFromBorder(){
        Board board;
        Coordinates2D coordinates = new Coordinates2D(x, y);
        Sign sign = signForTests;
        Object[][] objects = new Object[combinationSize][2];
        for(int i = 0; i < combinationSize; i++){
            board = new Board2D.Builder().boardSize(boardSize).build();
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


    @Test(dataProvider = "horizontalWiningCombinationsFarawayFromBorder")
    public void shouldReturnTrueIfThereIsHorizontalWiningCombinationFarawayFromBorder(Board2D boardToCheck, Coordinates2D coordinatesToCheck) {
        //Given
        UnitChecker horizontalChecker = new HorizontalChecker(boardToCheck, combinationSize);
        boardToCheck.addField(coordinatesToCheck, signForTests);
        //When
        boolean result = horizontalChecker.check(coordinatesToCheck);
        //Then
        Assert.assertTrue(result);
    }

}
