package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.boarddrawer.BoardDrawer;

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
    }



    @Override
    public void setBoardDrawer(BoardDrawer boardDrawer) {
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
    public void clearScreen() {

    }

    @Override
    public void print(String toPrint) {
        output.println(toPrint);
    }

    @Override
    public void printBoard() {

    }
}
