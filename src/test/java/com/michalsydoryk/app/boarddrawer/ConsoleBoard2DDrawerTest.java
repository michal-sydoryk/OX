package com.michalsydoryk.app.boarddrawer;

import com.beust.jcommander.internal.Console;
import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
        int boardSize = board.getSize();
        for(int row=0; row<boardSize; row++) {
            printRow(row, board);
        }

    }


    private void printRow(int row, Board board) {
        int boardSize = board.getSize();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(row);
        stringBuilder.append("  ");
        String emptyLine = "_";
        String bar = "|";
        String emptyLineBottomBoard = " ";
        Queue<Coordinates2D> coordinates = new ArrayDeque<>(board.getAllCoordinates());
        for(int col=0; col<boardSize; col++){
            int finalCol = col;
            Queue<Coordinates2D> lineCoordinates = coordinates.stream().filter(c -> c.getY() == finalCol).collect(Collectors.toCollection(ArrayDeque::new));
            if(lineCoordinates.peek().getX() == col){

            }
        }
        System.out.println(stringBuilder.toString());
    }

/*
    private static void printIndexRow() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for(int col = 0; col<boardSize; col++){
            stringBuilder.append(col);
            stringBuilder.append(" ");
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }
*/


}
