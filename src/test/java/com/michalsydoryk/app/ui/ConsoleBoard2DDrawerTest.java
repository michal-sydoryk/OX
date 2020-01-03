package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.board.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ConsoleBoard2DDrawerTest {

    private void addFieldsToBoard(Board board){
        board.addField(new Coordinates2D(0, 0), Sign.CROSS);
        board.addField(new Coordinates2D(1, 1), Sign.CROSS);
        board.addField(new Coordinates2D(9, 0), Sign.CROSS);
        board.addField(new Coordinates2D(4, 1), Sign.CROSS);
        board.addField(new Coordinates2D(5, 9), Sign.CROSS);
        board.addField(new Coordinates2D(7, 9), Sign.CROSS);
        board.addField(new Coordinates2D(9, 9), Sign.CROSS);
        board.addField(new Coordinates2D(24, 6), Sign.NAUGHT);
        board.addField(new Coordinates2D(2, 8), Sign.NAUGHT);
        board.addField(new Coordinates2D(3, 2), Sign.NAUGHT);
        board.addField(new Coordinates2D(4, 2), Sign.NAUGHT);
        board.addField(new Coordinates2D(24, 24), Sign.NAUGHT);
    }

    private void addFieldsToBoard10x10(Board board){
        board.addField(new Coordinates2D(0, 0), Sign.CROSS);
        board.addField(new Coordinates2D(1, 3), Sign.CROSS);
        board.addField(new Coordinates2D(9, 4), Sign.CROSS);

    }


    public void shouldPrintSameString(){
        //given
        int boardSize = 10;
        int combinationSize = 5;
        Board board = new Board2D.Builder()
                .boardSize(boardSize)
                .build();

        ConsoleBoard2DDrawer boardDrawer = new ConsoleBoard2DDrawer(board);
        addFieldsToBoard10x10(board);

        //when
        String toDraw = boardDrawer.draw();
        String expectedResult = "                       \n" +
                                "   0 1 2 3 4 5 6 7 8 9 \n" +
                                " 0 X|_|_|_|_|_|_|_|_|_\n" +
                                " 1 _|_|_|_|_|_|_|_|_|_\n" +
                                " 2 _|_|_|_|_|_|_|_|_|_\n" +
                                " 3 _|X|_|_|_|_|_|_|_|_\n" +
                                " 4 _|_|_|_|_|_|_|_|_|X\n" +
                                " 5 _|_|_|_|_|_|_|_|_|_\n" +
                                " 6 _|_|_|_|_|_|_|_|_|_\n" +
                                " 7 _|_|_|_|_|_|_|_|_|_\n" +
                                " 8 _|_|_|_|_|_|_|_|_|_\n" +
                                " 9  | | | | | | | | | \n";

        //then
        Assert.assertEquals(toDraw, expectedResult);

    }


}
