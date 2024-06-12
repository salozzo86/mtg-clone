package views;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import lombok.Getter;
import models.FieldModel;
import models.LifePointsModel;

@Getter
public class FieldView {
    private final Window window;
    private final Label playerLifePointsLabel;
    private final Label opponentLifePointsLabel;

    public FieldView() {
        window = new BasicWindow();

        Panel contentPanel = new Panel(new GridLayout(1));

        LifePointsModel playerLifePoints = new LifePointsModel();
        LifePointsModel opponenetLifePoints = new LifePointsModel();

        FieldModel fieldModel = new FieldModel(playerLifePoints, opponenetLifePoints);

        playerLifePointsLabel = new Label("Player Life Points: " + fieldModel.getPlayerLifePoints().getLifePoints());
        opponentLifePointsLabel = new Label("Opponent Life Points: " + fieldModel.getOpponentLifePoints().getLifePoints());

        contentPanel.addComponent(playerLifePointsLabel);
        contentPanel.addComponent(new EmptySpace());
        contentPanel.addComponent(opponentLifePointsLabel);

        window.setComponent(contentPanel);
    }

}
