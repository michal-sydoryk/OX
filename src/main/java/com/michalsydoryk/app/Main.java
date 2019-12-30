package com.michalsydoryk.app;

import com.michalsydoryk.app.gameengine.Game;
import com.michalsydoryk.app.gameengine.GameBuilder;
import com.michalsydoryk.app.gameengine.GameConfigurator;
import com.michalsydoryk.app.languagechooser.LanguageChooser;
import com.michalsydoryk.app.ui.ConsoleUI;
import com.michalsydoryk.app.ui.UI;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //--------create UI--------
        UI ui = new ConsoleUI(System.out, new Scanner(System.in));

        //-----choose language-----
        ResourceBundle resourceBundle = new LanguageChooser(ui).chooseLanguage();
        ui.setResourceBundle(resourceBundle);

        //----game configurator----
        GameConfigurator gameConfigurator = new GameConfigurator(ui);
        gameConfigurator.start();

        //----------game-----------
        Game game = GameBuilder.build(gameConfigurator.getGameConfiguration(), ui);
        game.start();
    }
}
