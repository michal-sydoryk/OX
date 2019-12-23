package com.michalsydoryk.app.boarddrawer;

import com.beust.jcommander.internal.Console;
import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.coordinatescomparator.Coordinates2DComparator;
import com.michalsydoryk.app.sign.Sign;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

@Test
public class ConsoleBoard2DDrawerTest {
    int boardSize = 25;
    int combinationSize = 5;
    Board board = new Board2D(boardSize, combinationSize);

    private void prepareBoard(){
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

    private String drawIndexesLine(){
        int boardSize = board.getSize();
        int numberOfLines = String.valueOf(boardSize).length();
        int numberOfLastSigns = boardSize%10;
        String empty10 = "          ";
        String form0To9 = "0 1 2 3 4 5 6 7 8 9 ";
        for(int i = 0; i<numberOfLines; i++){

        }
        return " ";
    }

    public void checkRow(){
        ConsoleBoard2DDrawer boardDrawer = new ConsoleBoard2DDrawer(board);
        prepareBoard();
        System.out.println(boardDrawer.draw());

    }

    public void checkEmptyRowDrawer(){
        ConsoleBoard2DDrawer boardDrawer = new ConsoleBoard2DDrawer(board);
        System.out.println(boardDrawer.drawEmptyRow(10));
    }


}
