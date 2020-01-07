package com.michalsydoryk.app.ui;

import java.util.Locale;
import java.util.ResourceBundle;

class LanguageChooser {
    UI ui;

    void setUi(UI ui) {
        this.ui = ui;
    }

    ResourceBundle chooseLanguage() {
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
                resourceBundle = ResourceBundle.getBundle("OXLabels", new Locale("pl", "PL"));
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
