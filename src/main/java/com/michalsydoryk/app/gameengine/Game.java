package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.boardchecker.BoardChecker;
import com.michalsydoryk.app.boardchecker.CheckResult;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.player.Player;
import com.michalsydoryk.app.sign.Sign;
import com.michalsydoryk.app.ui.UI;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final BoardChecker boardChecker;
    private final Players players;
    private final PlayersPoints playersPoints;
    private final int requiredPointNumber = 6;
    private final int numberOfRounds = 3;

    private UI ui;

    Game(Board board, BoardChecker boardChecker, Players players, PlayersPoints playersPoints, UI ui) {
        this.board = board;
        this.boardChecker = boardChecker;
        this.players = players;
        this.playersPoints = playersPoints;
        this.ui = ui;
    }

    public void start() {
        chooseOrder();
        int roundCounter = 0;

        while (true) {
            if (onePlayerHasRequiredPointsNumber(requiredPointNumber) || roundCounter >= numberOfRounds) break;
            CheckResult roundResult = round();
            addPoints(roundResult);
            ui.print(playersPoints.toString());
            board.clean();
            roundCounter++;
        }

        if (playersPoints.haveGameWinner())
            ui.print("winner_game_info", playersPoints.getPlayerWithBiggestPointNumber().toString());
        else
            ui.print("draw_game_info");

        ui.print("summary_info");
        ui.print(playersPoints.toString());
    }

    private boolean onePlayerHasRequiredPointsNumber(int requiredPointsNumber) {
        return playersPoints.onePlayerHasRequiredNumberOfPoints(requiredPointsNumber);
    }

    private void addPoints(CheckResult roundResult) {
        switch (roundResult){
            case WIN:
                playersPoints.addWinPoints(players.getActive());
                ui.print("player_win_a_round_info", players.getActive().toString());
                break;

            case DRAW:
                playersPoints.addDrawPoints();
                ui.print("draw_round_info");
                break;
        }
    }

    private CheckResult round() {
        while (true){
            Coordinates2D coordinates2D = addCoordinates();
            CheckResult checkResult = boardChecker.check(coordinates2D);

            switch (checkResult){
                case WIN:
                    ui.print("winning_board_combination");
                    ui.printBoard();
                    return checkResult;

                case DRAW:
                    ui.print("draw_board_combination");
                    ui.printBoard();
                    return checkResult;

                case NOTHING:
                    players.nextRoundOrder();
            }
        }
    }

    private Coordinates2D addCoordinates() {
        ui.printBoard();
        ui.print("ask_player_for_coordinates");
        ui.print("player", " " + players.getActive().toString());

        Player player = players.getActive();
        Sign sign = players.getActive().getSign();
        Coordinates2D coordinates2D = takeCoordinates();

        if (!board.addField(coordinates2D, sign)){
            ui.print("field_not_empty");
            coordinates2D = addCoordinates();

        }
        return coordinates2D;
    }

    private Coordinates2D takeCoordinates() {
        ui.print("enter_x_coordinate");
        int x = takeCoordinate();

        ui.print("enter_y_coordinate");
        int y = takeCoordinate();

        return new Coordinates2D(x,y);
    }

    private int takeCoordinate() {
        int number = ui.takeInputNumber();
        int MAX_INDEX = board.getSize() - 1;

        if(number < Board.MIN_INDEX || number > MAX_INDEX){
            ui.print("board_size_info", String.valueOf(MAX_INDEX));
            number = takeCoordinate();

        }
        return number;
    }

    private void chooseOrder() {
        boolean isNotChoosen = true;
        while(isNotChoosen) {
            ui.print("choose_order_info");

            List<Player> playerList = new ArrayList<>(players.getPlayerDeque());
            for (int i = 0; i < playerList.size(); i++) {
                ui.print(String.valueOf(i) + " - ", playerList.get(i).toString());
            }

            int number = ui.takeInputNumber();

            switch (number) {
                case 0:
                    ui.print("start_first_info", playerList.get(0).toString());
                    players.setFirstPlayer(playerList.get(0));
                    isNotChoosen = false;
                    break;

                case 1:
                    ui.print("start_first_info", playerList.get(1).toString());
                    players.setFirstPlayer(playerList.get(1));
                    isNotChoosen = false;
                    break;

                default:
                    ui.print("wrong_number_for_choose_player");
            }
        }


    }

}
