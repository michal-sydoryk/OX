
package com.michalsydoryk.app;

import com.michalsydoryk.app.gameengine.Game;
import com.michalsydoryk.app.gameengine.GameConfigurator;
import com.michalsydoryk.app.ui.ConsoleUI;
import com.michalsydoryk.app.ui.UI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //--------create UI--------
        UI ui = new ConsoleUI(System.out, new Scanner(System.in));
        ui.clearScreen();

        //-----choose language-----
        ui.chooseLanguage();

        //----game configurator----
        GameConfigurator gameConfigurator = new GameConfigurator(ui);
        Game game = gameConfigurator.createGame();

        //----------game-----------
        game.start();
    }
}
