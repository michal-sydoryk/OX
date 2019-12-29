package com.michalsydoryk.app.languagechooser;

import com.michalsydoryk.app.ui.UI;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageChooser {
    UI ui;

    public LanguageChooser(UI ui) {
        this.ui = ui;
    }


    public ResourceBundle chooseLanguage() {
        ResourceBundle resourceBundle = null;
        ui.clearScreen();
        ui.print("Select language:");
        ui.print("1 - EN");
        ui.print("2 - PL");
        String input = ui.takeInput();
        switch (input){
            case "1":
                ui.print("You choose English.");
                resourceBundle = ResourceBundle.getBundle("OXLabels", Locale.ENGLISH);
                break;

            case  "2":
                ui.print("Wybrałeś język Polski.");
                resourceBundle = ResourceBundle.getBundle("OXLabels", Locale.forLanguageTag("pl-PL"));
                break;

            default:
                ui.print("Wrong option!");
                chooseLanguage();
                break;
        }
        return resourceBundle;
    }
}
