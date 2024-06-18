package views;


import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.FieldModel;

@Getter
public class LifePointsView {
    private final Panel panel;

//    playerLifePointsLabel = new Label("Player Life Points: " + fieldModel.getPlayerLifePoints().getLifePoints());
//    opponentLifePointsLabel = new Label("Opponent Life Points: " + fieldModel.getOpponentLifePoints().getLifePoints());


    public LifePointsView(FieldModel fieldModel) {
        Label lifePointsLabel = new Label(String.valueOf(fieldModel.getPlayerLifePoints().getLifePoints()));
        panel = new Panel(new GridLayout(1));
        panel.addComponent(lifePointsLabel);
    }

}
