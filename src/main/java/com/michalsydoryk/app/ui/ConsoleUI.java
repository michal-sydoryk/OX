package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.boarddrawer.BoardDrawer;
import com.michalsydoryk.app.boarddrawer.ConsoleBoard2DDrawer;

import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleUI implements UI{
    PrintStream output;
    Scanner input;
    ResourceBundle resourceBundle = null;
    BoardDrawer consoleBoard2DDrawer;

    public ConsoleUI(PrintStream output, Scanner input) {
        this.output = output;
        this.input = input;
        this.resourceBundle = ResourceBundle.getBundle("OXLabels");
    }

    @Override
    public void setBoardDrawer(Board board) {
        consoleBoard2DDrawer = new ConsoleBoard2DDrawer(board);
    }

    @Override
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }


    @Override
    public String takeInput(){
        return input.nextLine();
    }

    @Override
    public int takeInputNumber() {
        String supposeNumber = input.nextLine();
        int number = 0;
        try{
            number = Integer.parseInt(supposeNumber);
            return number;
        }catch (NumberFormatException e){
            print("not_a_number");
            print("enter_a_number");
            number = takeInputNumber();
        }
        return number;
    }

    @Override
    public void clearScreen() {

    }

    @Override
    public void print(String toPrint) {
        if (resourceBundle.containsKey(toPrint))
            toPrint = resourceBundle.getString(toPrint);
        output.println(toPrint);
    }

    @Override
    public void print(String toPrint1, String toPrint2) {
        if (resourceBundle.containsKey(toPrint1))
            toPrint1 = resourceBundle.getString(toPrint1);
        output.println(toPrint1 + " " + toPrint2);
    }

    @Override
    public void printEmptyBoard(int boardSize) {
        Board board = new Board2D.Builder().boardSize(boardSize).build();
        BoardDrawer boardDrawer = new ConsoleBoard2DDrawer(board);
        output.print(boardDrawer.draw());
    }

    @Override
    public void printBoard() {

    }
}
