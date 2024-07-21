package views;


import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.LifePointsModel;

@Getter
public class LifePointsView {
    private final Panel panel;

    public LifePointsView(LifePointsModel lifePointsModel) {
        Label lifePointsLabel = new Label("Life Points: " + lifePointsModel.getLifePoints());
        panel = new Panel(new GridLayout(1));
        panel.addComponent(lifePointsLabel);
    }

}
