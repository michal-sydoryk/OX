package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.boarddrawer.BoardDrawer;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUI implements UI<String>{
    PrintStream output;
    Scanner input;
    BoardDrawer consoleBoard2DDrawer;

    public ConsoleUI(PrintStream output, Scanner input, BoardDrawer consoleBoard2DDrawer) {
        this.output = output;
        this.input = input;
        this.consoleBoard2DDrawer = consoleBoard2DDrawer;
    }



    @Override
    public int takeInput() {
        return 0;
    }

    @Override
    public void print(String toPrint) {

    }

    @Override
    public void printBoard() {

    }
}
