import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import lombok.Getter;
import views.FieldView;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class GameManager {
    private final Terminal terminal;
    private final Screen screen;
    private final WindowBasedTextGUI gui;
    private final Window window;
    private static final int CELL_WIDTH_PX = 8;  // Approximate width of a terminal cell in pixels
    private static final int CELL_HEIGHT_PX = 16; // Approximate height of a terminal cell in pixels

    public GameManager() throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidthPx = screenSize.width;
        int screenHeightPx = screenSize.height;
        int terminalWidth = screenWidthPx / CELL_WIDTH_PX;
        int terminalHeight = screenHeightPx / CELL_HEIGHT_PX;

        terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(terminalWidth, terminalHeight))
                .createTerminal();
        screen = new TerminalScreen(terminal);
        gui = new MultiWindowTextGUI(screen);
        window = new BasicWindow();
        initializeGui();
    }

    private void initializeGui() throws IOException {
        gui.setTheme(SimpleTheme.makeTheme(true,
                TextColor.ANSI.BLACK,
                TextColor.ANSI.BLUE_BRIGHT,
                TextColor.ANSI.BLUE_BRIGHT,
                TextColor.ANSI.BLUE_BRIGHT,
                TextColor.ANSI.BLUE_BRIGHT,
                TextColor.ANSI.GREEN,
                TextColor.ANSI.BLUE_BRIGHT
        ));
        screen.startScreen();
    }

    public void runMainMenu() {
        window.setHints(List.of(Window.Hint.CENTERED));
        Panel contentPanel = new Panel(new GridLayout(1));

        Label mainMenuLabel = new Label("What do you want to do?");
        Button startButton = new Button("Play a game", this::runDeckDecision);
        Button exitButton = new Button("Quit", this::quit);

        contentPanel.addComponent(mainMenuLabel);
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(startButton);
        contentPanel.addComponent(exitButton);

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);
    }

    private void quit() {
        try {
            screen.stopScreen();
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runDeckDecision() {
        Panel contentPanel = new Panel(new GridLayout(1));
        Label chooseDeckLabel = new Label("Choose your deck!");
        Button firstDeck = new Button("Aggro deck", this::startMatch);
        Button secondDeck = new Button("Control deck", this::startMatch);

        contentPanel.addComponent(chooseDeckLabel);
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(firstDeck);
        contentPanel.addComponent(secondDeck);

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);
    }

    // TODO Add argument for deck choice - either enum or a Deck object
    private void startMatch() {
        window.close();

        FieldView fieldView = new FieldView();

        Window fieldWindow = fieldView.getWindow();
        gui.addWindowAndWait(fieldWindow);
    }
}