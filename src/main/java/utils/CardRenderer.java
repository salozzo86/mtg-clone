package utils;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import models.CardModel;

import java.io.IOException;

public class CardRenderer {

    public void render(Screen screen, CardModel card, int x, int y) throws IOException {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

        textGraphics.drawRectangle(new TerminalPosition(x, y), new TerminalSize(10, 3), ' ');

        textGraphics.putString(x + 2, y + 1, card.getName(), SGR.BOLD);
        textGraphics.putString(x + 2, y + 2, "Mana Cost: " + card.getManaCost());
        textGraphics.putString(x + 2, y + 3, card.getSubType().getName());

        screen.refresh();
    }
}
