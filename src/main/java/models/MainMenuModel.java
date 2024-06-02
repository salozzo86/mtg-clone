package models;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;

@Getter
@AllArgsConstructor
public class MainMenuModel {
    private final Screen screen;
    private WindowBasedTextGUI windowBasedTextGUI;

    public void UIMain() throws IOException{
        final DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setTerminalEmulatorTitle("Magic The Gathering");
        final Terminal terminal = defaultTerminalFactory.createTerminal();

        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();
        screen.setCursorPosition(null);

        windowBasedTextGUI = new MultiWindowTextGUI(screen);
    }

    private

    public void run() {

    }


}
