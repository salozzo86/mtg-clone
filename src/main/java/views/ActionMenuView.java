package views;

import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;

@Getter
public class ActionMenuView {
    private final Panel contentPanel;
    private final Label actionMenuLabel;
    private final Button drawCard;
    private final Button playCard;
    private final Button pass;
    private final Button quitGame;


    public ActionMenuView() {
        contentPanel = new Panel(new GridLayout(1));
        actionMenuLabel = new Label("Actions");
        drawCard = new Button("Draw");
        playCard = new Button("Play a Card");
        pass = new Button("Pass");
        quitGame = new Button("Surrender");


        contentPanel.addComponent(actionMenuLabel);
        contentPanel.addComponent(drawCard);
        contentPanel.addComponent(playCard);
        contentPanel.addComponent(pass);
        contentPanel.addComponent(quitGame);
    }
}
