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
        ui.print("select_language");
        ui.print("english_option");
        ui.print("polish_option");
        String input = ui.takeInput();
        switch (input){
            case "1":
                resourceBundle = ResourceBundle.getBundle("OXLabels", new Locale("en", "US"));
                break;

            case  "2":
                resourceBundle = ResourceBundle.getBundle("OXLabels", Locale.forLanguageTag("pl_PL"));
                break;

            default:
                ui.clearScreen();
                ui.print("wrong_option");
                resourceBundle = chooseLanguage();
                break;
        }
        return resourceBundle;
    }
}
