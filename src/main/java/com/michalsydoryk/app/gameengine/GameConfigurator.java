package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.sign.Sign;
import com.michalsydoryk.app.ui.UI;

public class GameConfigurator {
    UI ui;

    public GameConfigurator(UI ui) {
        this.ui = ui;
    }

    public Game createGame(){
        Players players = createPlayers();
        int boardSize = addBoardSize();
        int combinationSize = addCombinationSize(boardSize);

        Game game = new Game.GameBuilder().
                addBoard(boardSize).
                addBoardChecker(combinationSize).
                addPlayersAndPlayersPoints(players).
                addUI(ui).
                build();

        return game;
    }

    private Players createPlayers(){
        ui.clearScreen();
        Players players = new Players();
        players.add(addPlayer(Sign.CROSS));
        ui.clearScreen();
        players.add(addPlayer(Sign.NAUGHT));
        return players;
    }

    private Player addPlayer(Sign sign){
        ui.print("enter_player_name", sign.toString());

        String playerName = ui.takeInput();

        if (isValidName(playerName)) return new Player(playerName, sign);

        ui.print("wrong_length_of_player_name");

        return addPlayer(sign);
    }

    private boolean isValidName(String playerName){
        int maxLengthOfPlayerName = 20;
        if(playerName.length() > maxLengthOfPlayerName) return false;
        return true;
    }

    private int addBoardSize() {
        ui.clearScreen();
        ui.print("choose_board_size_info");
        ui.printEmptyBoard(Board.MIN_SIZE);
        ui.print("enter_a_number_then_confirm");

        int boardSize = 3;
        int number;

        while(true){
            number = ui.takeInputNumber();
            ui.clearScreen();

            if(number == 0) break;

            if(number >= Board.MIN_SIZE && number <= 40) //change for max size Board.MAX_SIZE
                boardSize = number;
            else
                ui.print("wrong_board_size");

            ui.print("choose_board_size_info");
            ui.printEmptyBoard(boardSize);
            ui.print("enter_a_number_then_confirm");

        }

        return boardSize;
    }

    private int addCombinationSize(int boardSize) {
        ui.clearScreen();
        ui.print("combination_size_info");
        int combinationSize;

        while (true){
            combinationSize = ui.takeInputNumber();
            ui.clearScreen();

            if(combinationSize >= Board.MIN_SIZE && combinationSize <= boardSize) {
                return combinationSize;
            }
            else {
                ui.print("wrong_combination_size");
            }
        }
    }


}
