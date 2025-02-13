package views;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import lombok.Getter;
import models.CardModel;

@Getter
public class CardView {
    private final CardModel cardModel;

    public CardView(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    // use this method to re-render instead of updating existing ones
    public Panel getPanel() {
        final Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        Label nameLabel = new Label(cardModel.getName());
        //final Panel namePanel = new Panel(new GridLayout(1));

        Label manaCostLabel = new Label(String.valueOf(cardModel.getManaCost()));
        //final Panel manaCostPanel = new Panel(new GridLayout(1));

        Label typeLabel = new Label(cardModel.getType().getType().toString());
        //final Panel typePanel = new Panel(new GridLayout(1));

        Label subtypeLabel = new Label(cardModel.getSubType().getName());
        //final Panel subtypePanel = new Panel(new GridLayout(1));

        Label rarityLabel = new Label(cardModel.getRarity().toString());
        //final Panel rarityPanel = new Panel(new GridLayout(1));

        mainPanel.addComponent(nameLabel);
        mainPanel.addComponent(manaCostLabel);
        mainPanel.addComponent(typeLabel);
        mainPanel.addComponent(subtypeLabel);
        mainPanel.addComponent(rarityLabel);

        return mainPanel;
    }
}
