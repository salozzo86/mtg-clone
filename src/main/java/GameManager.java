import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Collections;

public class GameManager {

    public void runMainMenu() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
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
        final Window window = new BasicWindow();
        window.setHints(Collections.singletonList(Window.Hint.CENTERED));
        GridLayout gridLayout = new GridLayout(1);
        Panel contentPanel = new Panel(new GridLayout(2));
        gridLayout.setHorizontalSpacing(3);
        Button startButton = new Button("Start", () -> System.out.println("Starting the game..."));
        Button exitButton = new Button("Exit", window::close);

        contentPanel.addComponent(startButton);
        contentPanel.addComponent(exitButton);

        window.setComponent(contentPanel);
        gui.addWindowAndWait(window);

        screen.stopScreen();
    }

    public void run() throws IOException {
        runMainMenu();
    }
}
