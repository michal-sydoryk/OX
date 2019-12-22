package com.michalsydoryk.app.boarddrawer;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsoleBoard2DDrawer extends BoardDrawerAbstract<Board, String> {
    private static final String emptyLine = "_";
    private static final String bar = "|";
    private static final String emptyLineBottomBoard = " ";
    private static final String emptyLineWihBar = "_|";
    private static final String emptyLineBottomWithBar = " |";
    private static final String nextLine = "\n";


    ConsoleBoard2DDrawer(Board board) {
        super(board);
    }

    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        int boardSize = board.getSize();
        int lastRow = boardSize - 1;
        Queue<Coordinates2D> rowQueue;
        stringBuilder.append(drawIndexRow());
        for (int i = 0; i < lastRow; i++) {
            stringBuilder.append(String.format("%2s ", i));
            rowQueue = createRowQueue(i);
            if(rowQueue.isEmpty())
                stringBuilder.append(drawEmptyRow(boardSize));
            else
                stringBuilder.append(drawRow(rowQueue, boardSize));
            stringBuilder.append(nextLine);
        }
        rowQueue = createRowQueue(lastRow);
        stringBuilder.append(String.format("%2s ", lastRow));
        if (rowQueue.isEmpty())
            stringBuilder.append(drawLastEmptyRow(boardSize));
        else
            stringBuilder.append(drawLastRow(rowQueue, boardSize));

        stringBuilder.append(nextLine);
        return stringBuilder.toString();
    }

    private String drawIndexRow() {
        StringBuilder stringBuilder = new StringBuilder();
        int boardSize = board.getSize();
        int rowNumber = (boardSize - (boardSize%10)) / 10;
        if ()
        for (int i = 0; i < rowNumber; i++) {
            stringBuilder.append("   ");

        }
    }

    String drawLastRow(Queue<Coordinates2D> rowQueue, int rowSize) {
        Coordinates2D nearestCoordinates;
        int lastIndexInRow = rowSize - 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= lastIndexInRow; i++) {
            nearestCoordinates = rowQueue.poll();
            int indexOfNearestCoordinates = nearestCoordinates.getX();
            while (i < indexOfNearestCoordinates) {
                stringBuilder.append(emptyLineBottomWithBar);
                i++;
            }
            Sign sign = board.getSignFromField(nearestCoordinates);
            stringBuilder.append(sign);
            if (i < lastIndexInRow)
                stringBuilder.append(bar);

            if (rowQueue.isEmpty()) {
                if (i < lastIndexInRow)
                    stringBuilder.append(drawEmptyRow(lastIndexInRow - i));
                break;
            }
        }

        return stringBuilder.toString();
    }

     String drawLastEmptyRow(int rowSize) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndexInRow = rowSize -1;
        for (int i = 0; i < lastIndexInRow; i++) {
            stringBuilder.append(emptyLineBottomWithBar);
        }
        stringBuilder.append(emptyLineBottomBoard);
        return stringBuilder.toString();
    }

     String drawEmptyRow(int rowSize) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndexInRow = rowSize -1;

        for (int i = 0; i < lastIndexInRow; i++) {
            stringBuilder.append(emptyLineWihBar);
        }
        stringBuilder.append(emptyLine);
        return stringBuilder.toString();
    }

     String drawRow(Queue<Coordinates2D> rowQueue, int rowSize) {
        Coordinates2D nearestCoordinates;
        int lastIndexInRow = rowSize - 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= lastIndexInRow; i++) {
            nearestCoordinates = rowQueue.poll();
            int indexOfNearestCoordinates = nearestCoordinates.getX();
            while (i < indexOfNearestCoordinates) {
                stringBuilder.append(emptyLineWihBar);
                i++;
            }
            Sign sign = board.getSignFromField(nearestCoordinates);
            stringBuilder.append(sign);
            if (i < lastIndexInRow)
                stringBuilder.append(bar);

            if (rowQueue.isEmpty()) {
                if (i < lastIndexInRow)
                    stringBuilder.append(drawEmptyRow(lastIndexInRow - i));
                break;
            }
        }

        return stringBuilder.toString();
    }

     Queue<Coordinates2D> createRowQueue(int rowIndex){
        Set<Coordinates2D> coordinatesSet;
        coordinatesSet = board.getAllCoordinates();
        Queue<Coordinates2D> rowCoorQueue = coordinatesSet.stream()
                .filter(x -> x.getY() == rowIndex)
                .collect(Collectors.toCollection(LinkedList::new));
        return rowCoorQueue;
    }

}
