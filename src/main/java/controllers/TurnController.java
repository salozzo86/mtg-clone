// src/main/java/controllers/TurnController.java
package controllers;

import lombok.Getter;
import models.TurnPhase;

@Getter
public class TurnController {
    private TurnPhase currentPhase;

    public TurnController() {
        this.currentPhase = TurnPhase.DRAW;
    }

    public TurnPhase getCurrentPhase() {
        return currentPhase;
    }

    public void nextPhase() {
        switch (currentPhase) {
            case DRAW -> currentPhase = TurnPhase.MAIN;
            case MAIN -> currentPhase = TurnPhase.COMBAT;
            case COMBAT -> currentPhase = TurnPhase.END;
            case END -> currentPhase = TurnPhase.DRAW;
        }
    }
}
