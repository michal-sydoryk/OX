package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.boardchecker.Board2DChecker;
import com.michalsydoryk.app.boardchecker.BoardChecker;
import com.michalsydoryk.app.boardchecker.CheckResult;
import com.michalsydoryk.app.board.Coordinates2D;
import com.michalsydoryk.app.sign.Sign;
import com.michalsydoryk.app.ui.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that represents a game.
 */
public class Game {
    private final Board board;
    private final BoardChecker boardChecker;
    private final Players players;
    private final PlayersPoints playersPoints;
    private final int REQUIRED_POINT_NUMBER = 6;
    private final int NUMBER_OF_ROUNDS = 3;

    private UI ui;

    private Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.board;
        this.boardChecker = gameBuilder.boardChecker;
        this.players = gameBuilder.players;
        this.playersPoints = gameBuilder.playersPoints;
        this.ui = gameBuilder.ui;
        this.ui.setBoardDrawer(this.board);
    }

    public static class GameBuilder{
        private Board board;
        private Players players;
        private BoardChecker boardChecker;
        private PlayersPoints playersPoints;
        private UI ui;

        public GameBuilder addBoard(int boardSize){
            board = new Board2D.Builder().boardSize(boardSize).build();
            return this;
        }

        public GameBuilder addPlayersAndPlayersPoints(Players players){
            this.players = players;
            this.playersPoints = new PlayersPoints(players);
            return this;
        }

        public GameBuilder addUI(UI ui){
            this.ui = ui;
            return this;
        }

        public GameBuilder addBoardChecker(int combinationSize){
            this.boardChecker = new Board2DChecker(board, combinationSize);
            return this;
        }

        public Game build(){
            return new Game(this);
        }

    }

    public void start() {
        chooseOrder();
        int roundCounter = 0;

        while (true) {
            if (gameIsFinished(roundCounter)) break;
            CheckResult roundResult = round();
            addPoints(roundResult);
            ui.print(playersPoints.toString());
            ui.print("enter_any_sign_to_continue");
            ui.takeInput();
            board.clean();
            players.nextRoundOrder();
            roundCounter++;
        }
        ui.clearScreen();
        if (playersPoints.haveGameWinner())
            ui.print("winner_game_info", playersPoints.getPlayerWithBiggestPointNumber().toString());
        else
            ui.print("draw_game_info");

        ui.print("summary_info");
        ui.print(playersPoints.toString());
    }

    private void chooseOrder() {
        ui.clearScreen();
        boolean isNotChoosen = true;
        while(isNotChoosen) {
            ui.print("choose_order_info");

            List<Player> playerList = new ArrayList<>(players.getPlayerDeque());
            for (int i = 0; i < playerList.size(); i++) {
                ui.print(i + " - ", playerList.get(i).toString());
            }

            int number = ui.takeInputNumber();

            switch (number) {
                case 0:
                    ui.clearScreen();
                    ui.print("start_first_info", playerList.get(0).toString());
                    players.setFirstPlayer(playerList.get(0));
                    isNotChoosen = false;
                    break;

                case 1:
                    ui.clearScreen();
                    ui.print("start_first_info", playerList.get(1).toString());
                    players.setFirstPlayer(playerList.get(1));
                    isNotChoosen = false;
                    break;

                default:
                    ui.clearScreen();
                    ui.print("wrong_number_for_choose_player");
            }
        }
    }

    private boolean gameIsFinished(int roundCounter){
        return onePlayerHasRequiredPointsNumber(REQUIRED_POINT_NUMBER) || roundCounter >= NUMBER_OF_ROUNDS;
    }

    private CheckResult round() {
        while (true){
            ui.clearScreen();
            Coordinates2D coordinates2D = addCoordinates();
            CheckResult checkResult = boardChecker.check(coordinates2D);

            switch (checkResult){
                case WIN:
                    ui.clearScreen();
                    ui.print("winning_board_combination");
                    ui.printBoard();
                    return checkResult;

                case DRAW:
                    ui.clearScreen();
                    ui.print("draw_board_combination");
                    ui.printBoard();
                    return checkResult;

                case NOTHING:
                    players.nextRoundOrder();
            }
        }
    }

    private Coordinates2D addCoordinates() {
        Player player = players.getActive();
        ui.printBoard();
        ui.print("ask_player_for_coordinates");
        ui.print("player", " " + player.toString());

        Sign sign = player.getSign();
        Coordinates2D coordinates2D = takeCoordinates();

        if (!board.addField(coordinates2D, sign)){
            ui.clearScreen();
            ui.print("field_not_empty");
            coordinates2D = addCoordinates();

        }
        return coordinates2D;
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

    private boolean onePlayerHasRequiredPointsNumber(int requiredPointsNumber) {
        return playersPoints.onePlayerHasRequiredNumberOfPoints(requiredPointsNumber);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return  Objects.equals(board, game.board) &&
                Objects.equals(boardChecker, game.boardChecker) &&
                Objects.equals(players, game.players);
    }
}
