package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class ConsoleBoard2DDrawer extends AbstractBoardDrawer<Board, String> {
    private final int MAX_SIZE = 40;
    private final String EMPTY_LINE = "_";
    private final String BAR = "|";
    private final String EMPTY_LINE_BOTTOM_BOARD = " ";
    private final String EMPTY_LINE_WIH_BAR = "_|";
    private final String EMPTY_LINE_BOTTOM_WITH_BAR = " |";
    private final String NEXT_LINE = "\n";
    private final String INDEX_WHITESPACE = "   ";
    private final String INDEXES_UP = "                    1 1 1 1 1 1 1 1 1 1 2 2 2 2" +
                                             " 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 ";
    private final String INDEXES_DOWN = "0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 " +
                                               "0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 ";


    public ConsoleBoard2DDrawer(Board board) {
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
            stringBuilder.append(NEXT_LINE);
        }
        rowQueue = createRowQueue(lastRow);
        stringBuilder.append(String.format("%2s ", lastRow));
        if (rowQueue.isEmpty())
            stringBuilder.append(drawLastEmptyRow(boardSize));
        else
            stringBuilder.append(drawLastRow(rowQueue, boardSize));

        stringBuilder.append(NEXT_LINE);
        return stringBuilder.toString();
    }

    String drawIndexRow() {
        StringBuilder stringBuilder = new StringBuilder();
        int boardSize = board.getSize();
        stringBuilder.append(INDEX_WHITESPACE);
        stringBuilder.append(INDEXES_UP.substring(0, boardSize*2));
        stringBuilder.append(NEXT_LINE);
        stringBuilder.append(INDEX_WHITESPACE);
        stringBuilder.append(INDEXES_DOWN.substring(0, boardSize*2));
        stringBuilder.append(NEXT_LINE);
        return stringBuilder.toString();
    }

    String drawLastRow(Queue<Coordinates2D> rowQueue, int rowSize) {
        Coordinates2D nearestCoordinates;
        int lastIndexInRow = rowSize - 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= lastIndexInRow; i++) {
            nearestCoordinates = rowQueue.poll();
            int indexOfNearestCoordinates = nearestCoordinates.getX();
            while (i < indexOfNearestCoordinates) {
                stringBuilder.append(EMPTY_LINE_BOTTOM_WITH_BAR);
                i++;
            }
            Sign sign = board.getSignFromField(nearestCoordinates);
            stringBuilder.append(sign);
            if (i < lastIndexInRow)
                stringBuilder.append(BAR);

            if (rowQueue.isEmpty()) {
                if (i < lastIndexInRow)
                    stringBuilder.append(drawLastEmptyRow(lastIndexInRow - i));
                break;
            }
        }

        return stringBuilder.toString();
    }

     String drawLastEmptyRow(int rowSize) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndexInRow = rowSize -1;
        for (int i = 0; i < lastIndexInRow; i++) {
            stringBuilder.append(EMPTY_LINE_BOTTOM_WITH_BAR);
        }
        stringBuilder.append(EMPTY_LINE_BOTTOM_BOARD);
        return stringBuilder.toString();
    }

     String drawEmptyRow(int rowSize) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndexInRow = rowSize -1;

        for (int i = 0; i < lastIndexInRow; i++) {
            stringBuilder.append(EMPTY_LINE_WIH_BAR);
        }
        stringBuilder.append(EMPTY_LINE);
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
                stringBuilder.append(EMPTY_LINE_WIH_BAR);
                i++;
            }
            Sign sign = board.getSignFromField(nearestCoordinates);
            stringBuilder.append(sign);
            if (i < lastIndexInRow)
                stringBuilder.append(BAR);

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
