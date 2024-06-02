package views;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import controllers.DeckController;
import models.DeckModel;
import utils.SwingTerminal;

import java.io.IOException;

public class DeckView {
    public void deckViewGeneration() {
        try {
            SwingTerminal swingTerminal = new SwingTerminal();
            SwingTerminalFrame terminalFrame = swingTerminal.getSwingTerminalFrame();

            Screen screen = new TerminalScreen(terminalFrame);
            screen.startScreen();

            DeckController deckController = new DeckController();
            DeckModel deck = deckController.generateDeck(60);
            int x = 1;
            int y = 1;

            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            textGraphics.drawRectangle(new TerminalPosition(x, y), new TerminalSize(10, 3), ' ');
            textGraphics.putString(x, y, "Deck: " + deck.getCards().size() + " cards");
            screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
