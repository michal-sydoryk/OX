package com.michalsydoryk.app.boarddrawer;

import com.beust.jcommander.internal.Console;
import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Set;

@Test
public class ConsoleBoard2DDrawerTest {
    Board board;

    private void prepareBoard(){
        int boardSize = 25;
        int combinationSize = 5;
        board = new Board2D(boardSize, combinationSize);
        board.addField(new Coordinates2D(0, 0), Sign.CROSS);
        board.addField(new Coordinates2D(4, 1), Sign.CROSS);
        board.addField(new Coordinates2D(5, 5), Sign.CROSS);
        board.addField(new Coordinates2D(7, 5), Sign.CROSS);
        board.addField(new Coordinates2D(9, 9), Sign.CROSS);
        board.addField(new Coordinates2D(2, 6), Sign.NAUGHT);
        board.addField(new Coordinates2D(2, 8), Sign.NAUGHT);
        board.addField(new Coordinates2D(3, 2), Sign.NAUGHT);
        board.addField(new Coordinates2D(4, 2), Sign.NAUGHT);
        board.addField(new Coordinates2D(5, 6), Sign.NAUGHT);
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

    

    public void print(){
        prepareBoard();
        Set<Coordinates2D> coordinates = board.getAllCoordinates();

    }
}
