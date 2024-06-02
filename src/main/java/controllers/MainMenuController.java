package controllers;

import lombok.AllArgsConstructor;
import views.DeckView;

@AllArgsConstructor
public class MainMenuController {
    public void startGame() {
        System.out.println("Starting the game...");
    }

    public void quitGame() {
        System.out.println("Exiting the game...");
        System.exit(0);
    }

}
