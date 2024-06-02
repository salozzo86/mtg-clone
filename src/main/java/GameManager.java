import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Collections;

public class GameManager {
    private final Terminal terminal;
    private final Screen screen;
    private final WindowBasedTextGUI gui;
    private final Window window;

    public GameManager() throws IOException {
        terminal = new DefaultTerminalFactory().createTerminal();
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
        window.setHints(Collections.singletonList(Window.Hint.CENTERED));
        Panel contentPanel = new Panel(new GridLayout(1));

        Button startButton = new Button("Start", this::runDeckDecision);
        Button exitButton = new Button("Exit", window::close);

        contentPanel.addComponent(startButton);
        contentPanel.addComponent(exitButton);

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);
    }

    private void runDeckDecision() {
        Panel contentPanel = new Panel(new GridLayout(1));

        Button firstDeck = new Button("Aggro deck", () -> System.out.println("You have chosen an aggro deck"));
        Button secondDeck = new Button("Control deck", () -> System.out.println("You have chosen a control deck"));

        contentPanel.addComponent(firstDeck);
        contentPanel.addComponent(secondDeck);

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);
    }

    public void run() {
        try {
            runMainMenu();
        } finally {
            try {
                screen.stopScreen();
                terminal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
