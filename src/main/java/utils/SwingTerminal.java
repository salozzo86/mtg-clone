package utils;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import javax.swing.JFrame;


public class SwingTerminal {

    public SwingTerminalFrame getSwingTerminalFrame() {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        SwingTerminalFrame terminalFrame = terminalFactory.createSwingTerminal();
        terminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        terminalFrame.setUndecorated(true);
        terminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        terminalFrame.setVisible(true);
        return terminalFrame;

    }
}
