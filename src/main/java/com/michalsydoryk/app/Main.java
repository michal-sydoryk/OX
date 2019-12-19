package com.michalsydoryk.app;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {
    static private char[][] board;
    static private int boardSize;
    static private char x = 'x';
    static private char o = 'o';
    static private String player1 = "Player 1";
    static private String player2 = "Player 2";
    static private Deque<String> players;
    static private Scanner input = new Scanner(System.in);
    static private int numberOfSignToWin;

    //-----sings to print board------
    static private char emptyLine = '_';
    static private char emptyLineBottomBoard = ' ';
    static private char bar = '|';

    public static void main(String[] args) {
        configuration();
        setPlayersNames();
        setOrderOfMove();
        game();

    }

    private static void configuration(){
        //---------board Size----------
        System.out.print("Type board size: ");
        boardSize = input.nextInt();
        board = new char[boardSize][boardSize];
        //----fill with empty signs-----
        for(int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                board[i][j] = ' ';
            }
        }

        //-----number of sign to win----
        System.out.print("Type number of sign to win: ");
        numberOfSignToWin = input.nextInt();


    }

    private static void setPlayersNames(){
    }

    private static void setOrderOfMove(){
        System.out.println("Type who starts:");
        System.out.println("1 - Player 1");
        System.out.println("2 - Player 2");
        int whoStarts = input.nextInt();
        players = new ArrayDeque<>();
        players.add(player1);
        if(whoStarts == 1) players.add(player2);
        else players.addFirst(player2);
    }

    private static void game(){
        printBoard();
        while (checkForWin()){
            insertSign();
            changePlayers();
            printBoard();
        }
    }

    private static void changePlayers() {
        players.addLast(players.pollFirst());
    }

    private static void insertSign() {
        System.out.println(players.peekFirst() + " turn");
        System.out.println("Where do you want put sign?");
        System.out.print("Type column: ");
        int col = input.nextInt();
        System.out.println("Type row: ");
        int row = input.nextInt();

        char sign;
        if (players.peekFirst() == player1) sign = x;
        else sign = o;

        board[col][row] = sign;
    }

    private static void printBoard() {
        printIndexRow();
        for(int row=0; row<boardSize; row++) {
            printRow(row);
        }
    }

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


    private static void printRow(int row) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(row);
        stringBuilder.append("  ");
        for(int col=0; col<boardSize; col++){
            if(board[col][row] == ' ')
                if(row != (boardSize -1))
                    stringBuilder.append(emptyLine);
                else
                    stringBuilder.append(emptyLineBottomBoard);

            else stringBuilder.append(board[col][row]);
            if(col < (boardSize-1)) stringBuilder.append(bar);
        }
        System.out.println(stringBuilder.toString());
    }

    private static boolean checkForWin() {
        if(checkRowsForWin() || checkColumnsForWin() || checkCrossForWin()){
            System.out.println("X");
        }
        else if (checkRowsForWin() || checkColumnsForWin() || checkCrossForWin()){
            System.out.println("O");
        }
        return true;
    }

    private static boolean checkCrossForWin() {
        return false;
    }

    private static boolean checkColumnsForWin() {
        return false;
    }

    private static boolean checkRowsForWin() {
        return false;
    }
}

//examples of board
     /*
        o|x|o
        _|_|_
        o|x|x
        _|_|_
        x|x|o
         | |

        o|x|o
        o|x|x
        x|x|o

         | |o
        o| |x
        x|x|o

        _|_|o
        o|_|x  <--- the prettiest
        x|x|o
      */
