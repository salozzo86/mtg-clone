package views;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import controllers.CardController;
import models.LandModel;
import utils.CardRenderer;

import java.io.IOException;

public class CardView {
//    public void displayCard() {
//        // terminal setup
//        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
//        terminalFactory.setInitialTerminalSize(new TerminalSize(200, 80));
//        try {
//            // screen setup
//            Screen screen = terminalFactory.createScreen();
//            screen.startScreen();
//            screen.doResizeIfNecessary();
//
//            // class-specific setup
//            CardController cardController = new CardController();
//            LandModel[] cards = cardController.generateCards(7);
//            CardRenderer cardRenderer = new CardRenderer();
//
//            // rendering
//            int x = 1;
//            int y = 30;
//            for (LandModel card : cards) {
//                cardRenderer.render(screen, card, x, y);
//                x += 18;
//            }
//
//            screen.readInput();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
