package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;

public class Board2DChecker extends BoardCheckerAbstract<Board2D, Coordinates2D> {

    Board2DChecker(Board2D board2D) {
        super(board2D);
    }

    @Override
    public boolean check(Coordinates2D coordinates)
    {
        return false;
    }

    boolean checkVertical(Coordinates2D coordinatesToCheck){
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean upDirection = true;
        boolean downDirection = true;
        while (upDirection || downDirection){
            if (upDirection) {
                if (board.getSignFromField(new Coordinates2D(x, y - position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    upDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (downDirection) {
                if (board.getSignFromField(new Coordinates2D(x, y + position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    downDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }

    public boolean checkHorizontal(Coordinates2D coordinatesToCheck) {
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean leftDirection = true;
        boolean rightDirection = true;
        while (leftDirection || rightDirection){
            if (leftDirection) {
                if (board.getSignFromField(new Coordinates2D(x - position, y)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    leftDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (rightDirection) {
                if (board.getSignFromField(new Coordinates2D(x  + position, y)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    rightDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }



    public boolean checkDiagonalFromLeftUpCorner(Coordinates2D coordinatesToCheck) {
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean upDirection = true;
        boolean downDirection = true;
        while (upDirection || downDirection){
            if (upDirection) {
                if (board.getSignFromField(new Coordinates2D(x - position, y - position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    upDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (downDirection) {
                if (board.getSignFromField(new Coordinates2D(x  + position, y + position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    downDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }

    public boolean checkDiagonalFromLeftDownCorner(Coordinates2D coordinatesToCheck) {
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean upDirection = true;
        boolean downDirection = true;
        while (upDirection || downDirection){
            if (upDirection) {
                if (board.getSignFromField(new Coordinates2D(x + position, y - position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    upDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (downDirection) {
                if (board.getSignFromField(new Coordinates2D(x - position, y + position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    downDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }
}
